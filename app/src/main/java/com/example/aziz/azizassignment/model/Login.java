package com.example.aziz.azizassignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Aziz on 2/3/2017.
 */
public class Login implements Serializable {

    private String username = null;
    private String password = null;


    public String getUsername() {
        return username;
    }
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }
}
