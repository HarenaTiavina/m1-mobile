package com.smartkid.datasource.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.smartkid.models.Chapitre;

import java.util.List;

@Dao
public interface ChapitreDAO {
    @Insert
    void insertOne(Chapitre chapitre);

    @Insert
    void insertMany(Chapitre... chapitres);

    @Query("SELECT * FROM chapitre WHERE matiere__id=:matiere")
    List<Chapitre> findAll(String matiere);

    @Query("SELECT * FROM chapitre WHERE _id=:id")
    Chapitre find(String id);

    @Delete
    void deleteOne(Chapitre chapitre);

    @Delete
    void deleteMany(Chapitre... chapitres);

    @Query("DELETE FROM chapitre")
    void deleteAll();
}
