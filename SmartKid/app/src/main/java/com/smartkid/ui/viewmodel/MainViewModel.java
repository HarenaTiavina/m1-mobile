package com.smartkid.ui.viewmodel;

import android.app.Application;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;

import com.smartkid.MainActivity;
import com.smartkid.datasource.remote.CompteRemoteDataSource;
import com.smartkid.domainlayer.Common;
import com.smartkid.models.Compte;
import com.smartkid.services.RetrofitHelper;
import com.smartkid.ui.activity.ChoixProfilActivity;
import com.smartkid.ui.activity.LoaderDialog;
import com.smartkid.utils.ApiResponse;
import com.smartkid.utils.AppException;
import com.smartkid.utils.Credentials;
import com.smartkid.utils.LoginResponse;
import com.smartkid.utils.Serializer;

import java.util.regex.Matcher;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends AndroidViewModel {
    private CompteRemoteDataSource compteApi;
    private LoaderDialog loader;

    public MainViewModel(Application application){
        super(application);
        compteApi = RetrofitHelper.getInstance().getCompteApi();
    }

    public LoaderDialog getLoader() {
        return loader;
    }

    public void setLoader(LoaderDialog loader) {
        this.loader = loader;
    }

    public void login(EditText email, EditText password){
        loader.show();
        try {
            String emailValue = email.getText().toString();
            String passwordValue = password.getText().toString();

            int check = Common.isNullOrEmpty(emailValue, passwordValue);
            if (check > -1) throw new AppException("Champ requis", check);

            Matcher matcher = Common.VALID_EMAIL_ADDRESS_REGEX.matcher(emailValue);
            if(!matcher.find()) throw new AppException("Veuillez saisir une adresse email valide", 0);

            Compte compte = new Compte();
            compte.setEmail(emailValue);
            compte.setPassword(passwordValue);
            Call<LoginResponse> callLogin = compteApi.login(compte);
            callLogin.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    try{
                        LoginResponse res = response.body();
                        if(res == null) throw new Exception("Réponse null");
                        if(res.getStatus().compareTo("error") == 0) throw new Exception(res.getError());
                        Serializer.serialize(Credentials.build(res), "credentials.bin", getApplication());
                        Toast.makeText(getApplication(), "Content de vous revoir, "+res.getCompte().getPrenom(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplication(), ChoixProfilActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getApplication().startActivity(intent);

                        Intent actual = new Intent(getApplication(), MainActivity.class);
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                        Toast.makeText(getApplication(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(getApplication(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch (AppException appEx) {
            switch (appEx.getKey()) {
                case 0:
                    email.setError(appEx.getMessage());
                    break;
                case 1:
                    password.setError(appEx.getMessage());
                    break;
            }
        }
        catch(Exception ex){
            Toast.makeText(getApplication(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        loader.dismiss();
    }

    public void register(EditText nom, EditText prenom, EditText email, EditText password){
        try{
            String nomValue = nom.getText().toString();
            String prenomValue = prenom.getText().toString();
            String emailValue = email.getText().toString();
            String passwordValue = password.getText().toString();

            int check = Common.isNullOrEmpty(nomValue, prenomValue, emailValue, passwordValue);
            if (check > -1) throw new AppException("Champ requis", check);

            Matcher matcher = Common.VALID_EMAIL_ADDRESS_REGEX.matcher(emailValue);
            if(!matcher.find()) throw new AppException("Veuillez saisir une adresse email valide", 2);

            Compte compte = new Compte(null, nomValue, prenomValue, emailValue, passwordValue, null);
            Call<ApiResponse<String>> callRegister = compteApi.signup(compte);
            callRegister.enqueue(new Callback<ApiResponse<String>>() {
                @Override
                public void onResponse(Call<ApiResponse<String>> call, Response<ApiResponse<String>> response) {
                    try{
                        ApiResponse<String> res = response.body();
                        if(res == null) throw new Exception("Réponse null");
                        if(res.getStatus().compareTo("error") == 0) throw new Exception(res.getError());
                        nom.setText("");
                        prenom.setText("");
                        email.setText("");
                        password.setText("");
                        Toast.makeText(getApplication(), "Bravo, votre inscription est réussie, vous pouvez à présent vous connecter", Toast.LENGTH_LONG).show();
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                        Toast.makeText(getApplication(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ApiResponse<String>> call, Throwable t) {
                    Toast.makeText(getApplication(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch(AppException appEx){
            switch (appEx.getKey()) {
                case 0:
                    nom.setError(appEx.getMessage());
                    break;
                case 1:
                    prenom.setError(appEx.getMessage());
                    break;
                case 2:
                    email.setError(appEx.getMessage());
                    break;
                case 3:
                    password.setError(appEx.getMessage());
                    break;
            }
        }
        catch(Exception ex){
            Toast.makeText(getApplication(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
