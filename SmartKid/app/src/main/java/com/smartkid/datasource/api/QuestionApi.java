package com.smartkid.datasource.api;

import com.smartkid.models.Question;
import com.smartkid.utils.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface QuestionApi {
    @GET("api/question/lecon/{lecon}")
    Call<ApiResponse<Question[]>> findByLecon(@Path("lecon") String lecon);

    @GET("api/question/{id}")
    Call<ApiResponse<Question>> findById(@Path("id") String id);
}
