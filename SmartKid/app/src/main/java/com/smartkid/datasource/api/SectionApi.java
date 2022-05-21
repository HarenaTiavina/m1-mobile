package com.smartkid.datasource.api;

import com.smartkid.models.Section;
import com.smartkid.utils.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SectionApi {
    @GET("api/section/lecon/{lecon}")
    Call<ApiResponse<Section[]>> findByLecon(@Path("lecon") String lecon);

    @GET("api/section/{id}")
    Call<ApiResponse<Section>> findById(@Path("id") String id);
}
