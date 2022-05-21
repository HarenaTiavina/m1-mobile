package com.smartkid.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

@Entity(tableName = "question")
public class Question {
    @Expose
    @SerializedName("_id")
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    String _id;
    @Expose
    @SerializedName("lecon")
    @ColumnInfo(name = "_id")
    @Relation(parentColumn = "lecon", entityColumn = "_id")
    Lecon lecon;
    @Expose
    @SerializedName("question")
    @ColumnInfo(name = "question")
    String question;
    @Expose
    @SerializedName("choix")
    @ColumnInfo(name = "choix")
    String[] choix;
    @Expose
    @SerializedName("reponse")
    @ColumnInfo(name = "reponse")
    int reponse;
    @Expose
    @SerializedName("cultureGenerale")
    @ColumnInfo(name = "cultureGenerale")
    boolean cultureGenerale;
    @Expose
    @SerializedName("createdAt")
    @ColumnInfo(name = "createdAt")
    Timestamp createdAt;

    public Question(String _id, Lecon lecon, String question, String[] choix, int reponse, boolean cultureGenerale, Timestamp createdAt) {
        this._id = _id;
        this.lecon = lecon;
        this.question = question;
        this.choix = choix;
        this.reponse = reponse;
        this.cultureGenerale = cultureGenerale;
        this.createdAt = createdAt;
    }

    @Ignore
    public Question() {}

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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getChoix() {
        return choix;
    }

    public void setChoix(String[] choix) {
        this.choix = choix;
    }

    public int getReponse() {
        return reponse;
    }

    public void setReponse(int reponse) {
        this.reponse = reponse;
    }

    public boolean isCultureGenerale() {
        return cultureGenerale;
    }

    public void setCultureGenerale(boolean cultureGenerale) {
        this.cultureGenerale = cultureGenerale;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
