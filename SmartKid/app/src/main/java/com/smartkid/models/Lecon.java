package com.smartkid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

public class Lecon {
    @Expose
    @SerializedName("_id")
    String _id;
    @Expose
    @SerializedName("chapitre")
    Chapitre chapitre;
    @Expose
    @SerializedName("titre")
    String titre;
    @Expose
    @SerializedName("nbreQuestion")
    int nbreQuestion;
    @Expose
    @SerializedName("ordre")
    int ordre;
    @Expose
    @SerializedName("createdAt")
    Timestamp createdAt;

    public Lecon(String _id, Chapitre chapitre, String titre, int nbreQuestion, int ordre, Timestamp createdAt) {
        this._id = _id;
        this.chapitre = chapitre;
        this.titre = titre;
        this.nbreQuestion = nbreQuestion;
        this.ordre = ordre;
        this.createdAt = createdAt;
    }

    public Lecon() {}

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Chapitre getChapitre() {
        return chapitre;
    }

    public void setChapitre(Chapitre chapitre) {
        this.chapitre = chapitre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNbreQuestion() {
        return nbreQuestion;
    }

    public void setNbreQuestion(int nbreQuestion) {
        this.nbreQuestion = nbreQuestion;
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
