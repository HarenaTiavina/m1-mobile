package com.smartkid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Matiere {
    @Expose
    @SerializedName("_id")
    String _id;
    @Expose
    @SerializedName("titre")
    String titre;
    @Expose
    @SerializedName("description")
    String description;
    @Expose
    @SerializedName("icone")
    String icone;
    @Expose
    @SerializedName("couleur")
    String couleur;
    @Expose
    @SerializedName("createdAt")
    String createdAt;

    public Matiere(String _id, String titre, String description, String icone, String couleur, String createdAt) {
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
