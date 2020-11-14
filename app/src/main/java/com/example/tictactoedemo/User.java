package com.example.tictactoedemo;

public class User {

    public String email;
    public String fullname;
    public String username;
    public int win;
    public int lose;
    public int winvspc;
    public int winvsfriends;
    public String myID;
    public String opponentID;
    public String opponentEmail;
    public boolean request;
    public String accepted;
    public boolean currentlyPlaying;
    public Gameonline myGame;
    public boolean status;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getWinvspc() {
        return winvspc;
    }

    public void setWinvspc(int winvspc) {
        this.winvspc = winvspc;
    }

    public int getWinvsfriends() {
        return winvsfriends;
    }

    public void setWinvsfriends(int winvsfriends) {
        this.winvsfriends = winvsfriends;
    }

    public String getMyID() {
        return myID;
    }

    public void setMyID(String myID) {
        this.myID = myID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User() {

    }

    public User(String email, String fullname, String username,String id) {
        this.email = email;
        this.fullname = fullname;
        this.username = username;
        win=0;
        lose=0;
        winvspc = 0;
        winvsfriends = 0;
        this.myID = id;
        opponentID = "";
        opponentEmail = "";
        accepted = "none";
        request = false;
        myGame = null;
        currentlyPlaying = false;
        status = true;
    }
}
