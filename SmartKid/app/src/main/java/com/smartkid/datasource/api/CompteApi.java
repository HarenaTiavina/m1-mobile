package com.smartkid.datasource.api;

import com.smartkid.models.Compte;
import com.smartkid.utils.ApiResponse;
import com.smartkid.utils.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CompteApi {
    @POST("api/signup")
    Call<ApiResponse<String>> signup(@Body Compte compte);

    @POST("api/login")
    Call<LoginResponse> login(@Body String email, @Body String password);
}
