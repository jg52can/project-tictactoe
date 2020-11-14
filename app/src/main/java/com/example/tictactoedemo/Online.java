package com.example.tictactoedemo;

public class Online {
    public String username,email;

    public Online(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Online() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
