package com.smartkid.datasource.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.smartkid.models.Profil;

import java.util.List;

@Dao
public interface ProfilLocalDataSource {
    @Insert
    void insertOne(Profil profil);

    @Insert
    void insertMany(Profil... profils);

    @Query("SELECT * from profil")
    LiveData<List<Profil>> findAll();

    @Query("SELECT * from profil where _id=:id")
    Profil find(String id);

    @Delete
    void deleteOne(Profil profil);

    @Delete
    void deleteMany(Profil... profils);

    @Query("DELETE FROM profil")
    void deleteAll();
}