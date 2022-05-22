package com.smartkid.datasource.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.smartkid.models.Section;

import java.util.List;

@Dao
public interface SectionDAO {
    @Insert
    void insertOne(Section section);

    @Insert
    void insertMany(Section... sections);

    @Query("SELECT * FROM section WHERE lecon__id=:lecon")
    List<Section> findAll(String lecon);

    @Query("SELECT * FROM section WHERE _id=:id")
    Section find(String id);

    @Delete
    void deleteOne(Section section);

    @Delete
    void deleteMany(Section... sections);

    @Query("DELETE FROM section")
    void deleteAll();
}
