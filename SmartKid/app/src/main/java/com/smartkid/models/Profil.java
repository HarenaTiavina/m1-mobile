package com.smartkid.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

@Entity(tableName = "profil")
public class Profil {
    @Expose
    @SerializedName("_id")
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    String _id;
    @Expose
    @SerializedName("nom")
    @ColumnInfo(name = "nom")
    String nom;
    @Expose
    @SerializedName("dateNaissance")
    @ColumnInfo(name = "dateNaissance")
    Timestamp dateNaissance;
    @Expose
    @SerializedName("sexe")
    @ColumnInfo(name = "sexe")
    boolean sexe;
    @Expose
    @SerializedName("status")
    @ColumnInfo(name = "status")
    boolean status;
    @Expose
    @SerializedName("createdAt")
    @ColumnInfo(name = "createdAt")
    Timestamp createdAt;


    public Profil(String _id, String nom, Timestamp dateNaissance, boolean sexe, boolean status, Timestamp createdAt) {
        this._id = _id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.status = status;
        this.createdAt = createdAt;
    }

    @Ignore
    public Profil() {}

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Timestamp getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Timestamp dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public boolean isSexe() {
        return sexe;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
