package com.smartkid.ui.activity;

import android.app.Activity;
import android.app.Application;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.smartkid.datasource.remote.CompteRemoteDataSource;
import com.smartkid.datasource.remote.ProfilRemoteDataSource;
import com.smartkid.domainlayer.Common;
import com.smartkid.models.Compte;
import com.smartkid.models.Profil;
import com.smartkid.repositories.ProfilRepository;
import com.smartkid.services.RetrofitHelper;
import com.smartkid.utils.ApiResponse;
import com.smartkid.utils.AppException;
import com.smartkid.utils.LoginResponse;
import com.smartkid.utils.Serializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

            int checkEmail = Common.isNullOrEmpty(emailValue);
            int checkPassword = Common.isNullOrEmpty(passwordValue);
            if (checkEmail > -1) throw new AppException("Adresse email requise", 0);
            if (checkPassword > -1) throw new AppException("Mot de passe requis", 1);

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
                        Serializer.serialize(res, "credentials.bin", getApplication());
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

    public void register(Compte compte){
        Call<ApiResponse<String>> callRegister = compteApi.signup(compte);
        callRegister.enqueue(new Callback<ApiResponse<String>>() {
            @Override
            public void onResponse(Call<ApiResponse<String>> call, Response<ApiResponse<String>> response) {

            }

            @Override
            public void onFailure(Call<ApiResponse<String>> call, Throwable t) {

            }
        });
    }
}
