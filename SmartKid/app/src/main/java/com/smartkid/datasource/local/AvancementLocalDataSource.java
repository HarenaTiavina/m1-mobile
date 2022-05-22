package com.smartkid.datasource.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.smartkid.models.Avancement;

@Dao
public interface AvancementLocalDataSource {
    @Insert
    void insertOne(Avancement avancement);

    @Insert
    void insertMany(Avancement... avancements);

    @Query("SELECT * FROM avancement WHERE lecon__id=:lecon")
    Avancement findByLecon(String lecon);

    @Query("SELECT * FROM avancement WHERE _id=:id")
    Avancement find(String id);

    @Delete
    void deleteOne(Avancement avancement);

    @Query("DELETE FROM avancement WHERE lecon__id=:lecon")
    void deleteByLecon(String lecon);

    @Delete
    void deleteMany(Avancement... avancements);

    @Query("DELETE FROM avancement")
    void deleteAll();
}
