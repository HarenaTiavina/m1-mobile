package com.smartkid.ui.activity;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.smartkid.models.Profil;
import com.smartkid.repositories.ProfilRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private ProfilRepository profilRepository;
    private LiveData<List<Profil>> data;

    public MainViewModel(Application application){
        super(application);
        profilRepository = new ProfilRepository(application);
        data = profilRepository.getProfils();
    }

    public LiveData<List<Profil>> getData() {
        return data;
    }

    public void insertProfil(Profil profil){
        profilRepository.insertDB(profil);
    }
}
