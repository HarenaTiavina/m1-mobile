package com.smartkid.datasource.remote;

import com.smartkid.models.Compte;
import com.smartkid.utils.ApiResponse;
import com.smartkid.utils.LoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CompteRemoteDataSource {
    @POST("api/compte/signup")
    Call<ApiResponse<String>> signup(@Body Compte compte);

    @POST("api/compte/login")
    Call<LoginResponse> login(@Body Compte compte);
}
