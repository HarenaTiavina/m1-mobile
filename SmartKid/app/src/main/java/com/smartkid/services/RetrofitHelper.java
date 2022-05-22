package com.smartkid.services;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartkid.datasource.remote.CompteRemoteDataSource;
import com.smartkid.datasource.remote.ProfilRemoteDataSource;
import com.smartkid.datasource.remote.QuestionRemoteDataSource;
import com.smartkid.datasource.remote.SectionRemoteDataSource;
import com.smartkid.utils.TimestampSerializer;

import java.sql.Timestamp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    public final static String BASE_URL = "http://192.168.8.100:3333/";
    static RetrofitHelper instance = new RetrofitHelper();

    private Retrofit retrofit;
    private CompteRemoteDataSource compteApi;
    private ProfilRemoteDataSource profilApi;
    private QuestionRemoteDataSource questionApi;
    private SectionRemoteDataSource sectionApi;

    private RetrofitHelper(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Timestamp.class, new TimestampSerializer());
        Gson gson = gsonBuilder.create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static RetrofitHelper getInstance() {
        return instance;
    }

    public CompteRemoteDataSource getCompteApi() {
        if(compteApi == null){
            compteApi = retrofit.create(CompteRemoteDataSource.class);
        }
        return compteApi;
    }

    public ProfilRemoteDataSource getProfilApi() {
        if(profilApi == null){
            profilApi = retrofit.create(ProfilRemoteDataSource.class);
        }
        return profilApi;
    }

    public QuestionRemoteDataSource getQuestionApi() {
        if(questionApi == null){
            questionApi = retrofit.create(QuestionRemoteDataSource.class);
        }
        return questionApi;
    }

    public SectionRemoteDataSource getSectionApi() {
        if(sectionApi == null){
            sectionApi = retrofit.create(SectionRemoteDataSource.class);
        }
        return sectionApi;
    }
}
