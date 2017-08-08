package com.example.myapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Credentials {

    private String username, password;

    public Credentials() {
    }

    public Credentials(String username, String password) {
        this.username = username;
        this.password = MD5Encrypter.encrypt(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = MD5Encrypter.encrypt(password);
    }
}
