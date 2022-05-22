package com.smartkid.datasource.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.smartkid.models.Profil;

@Dao
public interface ProfilDAO {
    @Insert
    void insertOne(Profil profil);

    @Insert
    void insertMany(Profil... profils);

    @Query("SELECT * from profil")
    Profil[] findAll();

    @Query("SELECT * from profil where _id=:id")
    Profil find(String id);

    @Delete
    void deleteOne(Profil profil);

    @Delete
    void deleteMany(Profil... profils);

    @Query("DELETE FROM profil")
    void deleteAll();
}