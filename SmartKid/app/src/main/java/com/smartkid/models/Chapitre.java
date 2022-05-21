package com.smartkid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

public class Chapitre {
    @Expose
    @SerializedName("_id")
    String _id;
    @Expose
    @SerializedName("matiere")
    Matiere matiere;
    @Expose
    @SerializedName("titre")
    String titre;
    @Expose
    @SerializedName("description")
    String description;
    @Expose
    @SerializedName("ordre")
    int ordre;
    @Expose
    @SerializedName("createdAt")
    Timestamp createdAt;

    public Chapitre(String _id, Matiere matiere, String titre, String description, int ordre, Timestamp createdAt) {
        this._id = _id;
        this.matiere = matiere;
        this.titre = titre;
        this.description = description;
        this.ordre = ordre;
        this.createdAt = createdAt;
    }

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
