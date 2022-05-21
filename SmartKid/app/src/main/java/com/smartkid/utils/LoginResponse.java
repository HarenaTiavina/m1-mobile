package com.smartkid.utils;

import com.smartkid.models.Compte;

import java.io.Serializable;

public class LoginResponse implements Serializable {
    String status;
    String token;
    Compte compte;

    public LoginResponse(String status, String token, Compte compte) {
        this.status = status;
        this.token = token;
        this.compte = compte;
    }

    public LoginResponse() {}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
