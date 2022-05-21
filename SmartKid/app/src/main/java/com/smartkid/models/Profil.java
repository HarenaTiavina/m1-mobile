package com.smartkid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

public class Profil {
    @Expose
    @SerializedName("_id")
    String _id;
    @Expose
    @SerializedName("nom")
    String nom;
    @Expose
    @SerializedName("dateNaissance")
    Timestamp dateNaissance;
    @Expose
    @SerializedName("sexe")
    boolean sexe;
    @Expose
    @SerializedName("status")
    boolean status;
    @Expose
    @SerializedName("createdAt")
    Timestamp createdAt;

    public Profil(String _id, String nom, Timestamp dateNaissance, boolean sexe, boolean status, Timestamp createdAt) {
        this._id = _id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.status = status;
        this.createdAt = createdAt;
    }

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
