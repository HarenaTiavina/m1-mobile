package com.smartkid.ui.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.smartkid.datasource.remote.ProfilRemoteDataSource;
import com.smartkid.services.RetrofitHelper;
import com.smartkid.ui.activity.LoaderDialog;

public class ProfilViewModel extends AndroidViewModel {
    private ProfilRemoteDataSource profilApi;
    private LoaderDialog loader;

    public ProfilViewModel(Application application){
        super(application);
        profilApi = RetrofitHelper.getInstance().getProfilApi();
    }
}
