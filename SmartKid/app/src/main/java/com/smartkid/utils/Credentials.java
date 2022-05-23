package com.smartkid.utils;

import java.io.Serializable;

public class Credentials implements Serializable {
    String token;
    String nom;
    String prenom;
    String email;

    private Credentials(String token, String nom, String prenom, String email) {
        this.token = token;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    private Credentials() {}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public static Credentials build(LoginResponse loginResponse){
        return new Credentials(loginResponse.getToken(), loginResponse.getCompte().getNom(), loginResponse.getCompte().getPrenom(), loginResponse.getCompte().getEmail());
    }
}
