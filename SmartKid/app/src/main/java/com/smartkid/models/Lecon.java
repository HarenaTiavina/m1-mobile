package com.smartkid.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

@Entity(tableName = "lecon")
public class Lecon {
    @Expose
    @SerializedName("_id")
    @PrimaryKey
    @NonNull
    String _id;
    @Expose
    @SerializedName("chapitre")
    @Embedded(prefix = "chapitre_")
    Chapitre chapitre;
    @Expose
    @SerializedName("titre")
    @ColumnInfo(name = "titre")
    String titre;
    @Expose
    @SerializedName("nbreQuestion")
    @ColumnInfo(name = "nbreQuestion")
    int nbreQuestion;
    @Expose
    @SerializedName("ordre")
    @ColumnInfo(name = "ordre")
    int ordre;
    @Expose
    @SerializedName("createdAt")
    @ColumnInfo(name = "createdAt")
    Timestamp createdAt;

    @Ignore
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
