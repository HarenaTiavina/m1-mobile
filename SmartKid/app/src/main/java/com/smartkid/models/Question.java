package com.smartkid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

public class Question {
    @Expose
    @SerializedName("_id")
    String _id;
    @Expose
    @SerializedName("lecon")
    Lecon lecon;
    @Expose
    @SerializedName("question")
    String question;
    @Expose
    @SerializedName("choix")
    String[] choix;
    @Expose
    @SerializedName("reponse")
    int reponse;
    @Expose
    @SerializedName("cultureGenerale")
    boolean cultureGenerale;
    @Expose
    @SerializedName("createdAt")
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
