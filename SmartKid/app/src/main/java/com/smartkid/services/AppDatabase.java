package com.smartkid.services;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.smartkid.datasource.local.AvancementLocalDataSource;
import com.smartkid.datasource.local.ChapitreLocalDataSource;
import com.smartkid.datasource.local.LeconLocalDataSource;
import com.smartkid.datasource.local.MatiereLocalDataSource;
import com.smartkid.datasource.local.ProfilLocalDataSource;
import com.smartkid.datasource.local.SectionLocalDataSource;
import com.smartkid.models.Avancement;
import com.smartkid.models.Chapitre;
import com.smartkid.models.Lecon;
import com.smartkid.models.Matiere;
import com.smartkid.models.Profil;
import com.smartkid.models.Section;
import com.smartkid.utils.TimestampConverter;

@TypeConverters({TimestampConverter.class})
@Database( entities = {Profil.class, Matiere.class, Chapitre.class, Lecon.class, Section.class, Avancement.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "smartkids";
    private static AppDatabase instance;

    public abstract ProfilLocalDataSource profilDAO();
    public abstract MatiereLocalDataSource matiereDAO();
    public abstract ChapitreLocalDataSource chapitreDAO();
    public abstract LeconLocalDataSource leconDAO();
    public abstract SectionLocalDataSource sectionDAO();
    public abstract AvancementLocalDataSource avancementDAO();

    public static synchronized AppDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
