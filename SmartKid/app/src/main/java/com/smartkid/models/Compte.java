package com.smartkid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

public class Compte {
    @Expose
    @SerializedName("_id")
    String _id;
    @Expose
    @SerializedName("nom")
    String nom;
    @Expose
    @SerializedName("prenom")
    String prenom;
    @Expose
    @SerializedName("email")
    String email;
    @Expose
    @SerializedName("password")
    String password;
    @Expose
    @SerializedName("createdAt")
    Timestamp createdAt;

    public Compte(String _id, String nom, String prenom, String email, String password, Timestamp createdAt) {
        this.set_id(_id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setEmail(email);
        this.setPassword(password);
        this.setCreatedAt(createdAt);
    }

    public Compte() {}

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
