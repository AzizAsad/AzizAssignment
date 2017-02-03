package com.example.aziz.azizassignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Aziz on 02/03/2017.
 */
public class Product implements Serializable {
    private String gender;
    private String email;
    private String phone;
    private Picture picture;
    private Login login;
    private UserName name;
    private Location location;

    public Product() {

    }


    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Picture getPicture() {
        return picture;
    }

    @JsonProperty("picture")
    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Login getLogin() {
        return login;
    }

    @JsonProperty("login")
    public void setLogin(Login login) {
        this.login = login;
    }

    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    public UserName getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(UserName name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    public class UserName implements Serializable
    {
        private String title;
        private String first;
        private String last;


        public String getTitle() {
            return title;
        }
        @JsonProperty("title")
        public void setTitle(String title) {
            this.title = title;
        }

        public String getFirst() {
            return first;
        }
        @JsonProperty("first")
        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }
        @JsonProperty("last")
        public void setLast(String last) {
            this.last = last;
        }
    }


}
