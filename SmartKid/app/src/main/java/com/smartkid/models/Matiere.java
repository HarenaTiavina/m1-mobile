package com.smartkid.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

@Entity(tableName = "matiere")
public class Matiere {
    @Expose
    @SerializedName("_id")
    @PrimaryKey
    @NonNull
    String _id;
    @Expose
    @SerializedName("titre")
    @ColumnInfo(name = "titre")
    String titre;
    @Expose
    @SerializedName("description")
    @ColumnInfo(name = "description")
    String description;
    @Expose
    @SerializedName("icone")
    @ColumnInfo(name = "icone")
    String icone;
    @Expose
    @SerializedName("couleur")
    @ColumnInfo(name = "couleur")
    String couleur;
    @Expose
    @SerializedName("createdAt")
    @ColumnInfo(name = "createdAt")
    Timestamp createdAt;

    @Ignore
    public Matiere(String _id, String titre, String description, String icone, String couleur, Timestamp createdAt) {
        this._id = _id;
        this.titre = titre;
        this.description = description;
        this.icone = icone;
        this.couleur = couleur;
        this.createdAt = createdAt;
    }

    public Matiere() {}

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
