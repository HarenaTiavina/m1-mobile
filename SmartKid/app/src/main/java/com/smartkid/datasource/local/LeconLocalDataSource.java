package com.smartkid.datasource.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.smartkid.models.Lecon;

import java.util.List;

@Dao
public interface LeconLocalDataSource {
    @Insert
    void insertOne(Lecon lecon);

    @Insert
    void insertMany(Lecon... lecons);

    @Query("SELECT * FROM lecon WHERE chapitre__id=:chapitre")
    LiveData<List<Lecon>> findAll(String chapitre);

    @Query("SELECT * FROM lecon WHERE _id=:id")
    Lecon find(String id);

    @Delete
    void deleteOne(Lecon lecon);

    @Delete
    void deleteMany(Lecon lecon);

    @Query("DELETE FROM lecon")
    void deleteAll();
}
