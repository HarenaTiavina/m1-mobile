package com.smartkid.models;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

@Entity(tableName = "avancement")
public class Avancement {
    @Expose
    @SerializedName("_id")
    @PrimaryKey
    @NonNull
    String _id;
    @Expose
    @SerializedName("lecon")
    @Embedded(prefix = "lecon_")
    Lecon lecon;
    @Expose
    @SerializedName("profil")
    @Embedded(prefix = "profil_")
    Profil profil;
    @Expose
    @SerializedName("score")
    int score;
    @Expose
    @SerializedName("createdAt")
    Timestamp createdAt;

    @Ignore
    public Avancement(String _id, Lecon lecon, Profil profil, int score, Timestamp createdAt) {
        this._id = _id;
        this.lecon = lecon;
        this.profil = profil;
        this.score = score;
        this.createdAt = createdAt;
    }

    public Avancement() {}

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Lecon getLecon() {
        return lecon;
    }

    public void setLecon(Lecon lecon) {
        this.lecon = lecon;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
