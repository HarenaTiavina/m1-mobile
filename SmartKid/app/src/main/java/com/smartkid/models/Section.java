package com.smartkid.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

@Entity(tableName = "section")
public class Section {
    @Expose
    @SerializedName("_id")
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    String _id;
    @Expose
    @SerializedName("lecon")
    @ColumnInfo(name = "lecon")
    @Relation(parentColumn = "lecon", entityColumn = "_id")
    Lecon lecon;
    @Expose
    @SerializedName("titre")
    @ColumnInfo(name = "titre")
    String titre;
    @Expose
    @SerializedName("contenu")
    @ColumnInfo(name = "contenu")
    String contenu;
    @Expose
    @SerializedName("video")
    @ColumnInfo(name = "video")
    String[] video;
    @Expose
    @SerializedName("image")
    @ColumnInfo(name = "image")
    String[] image;
    @Expose
    @SerializedName("ordre")
    @ColumnInfo(name = "ordre")
    int ordre;
    @Expose
    @SerializedName("createdAt")
    @ColumnInfo(name = "createdAt")
    Timestamp createdAt;

    public Section(String _id, Lecon lecon, String titre, String contenu, String[] video, String[] image, int ordre, Timestamp createdAt) {
        this._id = _id;
        this.lecon = lecon;
        this.titre = titre;
        this.contenu = contenu;
        this.video = video;
        this.image = image;
        this.ordre = ordre;
        this.createdAt = createdAt;
    }

    @Ignore
    public Section() {}

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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String[] getVideo() {
        return video;
    }

    public void setVideo(String[] video) {
        this.video = video;
    }

    public String[] getImage() {
        return image;
    }

    public void setImage(String[] image) {
        this.image = image;
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
