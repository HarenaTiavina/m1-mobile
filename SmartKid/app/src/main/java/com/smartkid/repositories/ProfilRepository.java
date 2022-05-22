package com.smartkid.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.smartkid.datasource.local.ProfilLocalDataSource;
import com.smartkid.models.Profil;
import com.smartkid.services.AppDatabase;

import java.util.List;

public class ProfilRepository {
    private ProfilLocalDataSource profilLocalDataSource;
    private LiveData<List<Profil>> profils;

    public LiveData<List<Profil>> getProfils() {
        return profils;
    }

    public ProfilRepository(Application application){
        AppDatabase db = AppDatabase.getInstance(application);
        profilLocalDataSource = db.profilDAO();
        profils = profilLocalDataSource.findAll();
    }

    public void insertDB(Profil profil){
        new InsertProfilAsyncTask(profilLocalDataSource).execute(profil);
    }

    private static class InsertProfilAsyncTask extends AsyncTask<Profil, Void, Void> {
        private ProfilLocalDataSource profilLocalDataSource;

        private InsertProfilAsyncTask(ProfilLocalDataSource profilLocalDataSource) {
            this.profilLocalDataSource = profilLocalDataSource;
        }

        @Override
        protected Void doInBackground(Profil... profils) {
            profilLocalDataSource.insertOne(profils[0]);
            return null;
        }
    }
}
