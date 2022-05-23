package com.smartkid.ui.activity;

import android.app.Activity;
import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.smartkid.datasource.remote.CompteRemoteDataSource;
import com.smartkid.datasource.remote.ProfilRemoteDataSource;
import com.smartkid.models.Compte;
import com.smartkid.models.Profil;
import com.smartkid.repositories.ProfilRepository;
import com.smartkid.services.RetrofitHelper;
import com.smartkid.utils.ApiResponse;
import com.smartkid.utils.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends AndroidViewModel {
    private CompteRemoteDataSource compteApi;
    private LoaderDialog loader;

    public MainViewModel(Application application, Activity activity){
        super(application);
        compteApi = RetrofitHelper.getInstance().getCompteApi();
        loader = new LoaderDialog(activity);
    }

    public void signup(String email, String password){
        Call<LoginResponse> callLogin = compteApi.login(email, password);
        callLogin.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
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

    public void show(){
        loader.show();
    }

    public void dismiss(){
        loader.dismiss();
    }
}
