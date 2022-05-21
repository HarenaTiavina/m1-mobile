package com.smartkid.models;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

@Entity(tableName = "chapitre")
public class Chapitre {
    @Expose
    @SerializedName("_id")
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    String _id;
    @Expose
    @SerializedName("matiere")
    @ColumnInfo(name = "matiere")
    @Embedded
    Matiere matiere;
    @Expose
    @SerializedName("titre")
    @ColumnInfo(name = "titre")
    String titre;
    @Expose
    @SerializedName("description")
    @ColumnInfo(name = "description")
    String description;
    @Expose
    @SerializedName("ordre")
    @ColumnInfo(name = "ordre")
    int ordre;
    @Expose
    @SerializedName("createdAt")
    @ColumnInfo(name = "createdAt")
    Timestamp createdAt;

    public Chapitre(String _id, Matiere matiere, String titre, String description, int ordre, Timestamp createdAt) {
        this._id = _id;
        this.matiere = matiere;
        this.titre = titre;
        this.description = description;
        this.ordre = ordre;
        this.createdAt = createdAt;
    }

    @Ignore
    public Chapitre() {}

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
