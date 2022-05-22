package com.smartkid.utils;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.smartkid.datasource.room.AvancementDAO;
import com.smartkid.datasource.room.ChapitreDAO;
import com.smartkid.datasource.room.LeconDAO;
import com.smartkid.datasource.room.MatiereDAO;
import com.smartkid.datasource.room.ProfilDAO;
import com.smartkid.datasource.room.SectionDAO;
import com.smartkid.models.Avancement;
import com.smartkid.models.Chapitre;
import com.smartkid.models.Lecon;
import com.smartkid.models.Matiere;
import com.smartkid.models.Profil;
import com.smartkid.models.Section;

@TypeConverters({TimestampConverter.class})
@Database( entities = {Profil.class, Matiere.class, Chapitre.class, Lecon.class, Section.class, Avancement.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProfilDAO profilDAO();
    public abstract MatiereDAO matiereDAO();
    public abstract ChapitreDAO chapitreDAO();
    public abstract LeconDAO leconDAO();
    public abstract SectionDAO sectionDAO();
    public abstract AvancementDAO avancementDAO();
}
