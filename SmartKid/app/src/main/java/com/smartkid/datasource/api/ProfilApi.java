package com.smartkid.datasource.api;

import com.smartkid.models.Profil;
import com.smartkid.utils.ApiResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProfilApi {
    @POST("api/profil")
    Call<ApiResponse<Profil>> create(@Header("Authorization") String bearer);

    @GET("api/profil")
    Call<ApiResponse<Profil[]>> findAll(@Header("Authorization") String bearer);

    @GET("api/profil/{id}")
    Call<ApiResponse<Profil>> findById(@Header("Authorization") String bearer, @Path("id") String id);

    @PUT("api/profil/{id}")
    Call<ApiResponse<Profil>> update(@Header("Authorization") String bearer, @Path("id") String id, @Body Profil profil);

    @DELETE("api/profil/{id}")
    Call<ApiResponse<Profil>> delete(@Header("Authorization") String bearer, @Path("id") String id);
}
