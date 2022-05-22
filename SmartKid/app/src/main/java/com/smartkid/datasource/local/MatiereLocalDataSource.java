package com.smartkid.datasource.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.smartkid.models.Matiere;

@Dao
public interface MatiereLocalDataSource {
    @Insert
    void insertOne(Matiere matiere);

    @Insert
    void insertMany(Matiere... matieres);

    @Query("SELECT * FROM matiere")
    Matiere[] findAll();

    @Query("SELECT * FROM matiere WHERE _id=:id")
    Matiere find(String id);

    @Delete
    void deleteOne(Matiere matiere);

    @Delete
    void deleteMany(Matiere... matieres);

    @Query("DELETE FROM matiere")
    void deleteAll();
}
