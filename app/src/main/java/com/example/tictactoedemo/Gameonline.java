package com.example.tictactoedemo;

public class Gameonline {

    public boolean gameInProgress;
    public String currentTurn;
    public int currentMove;
    public String currentLetter;

    public Gameonline() {
    }

    public Gameonline(String currentTurn) {
        this.currentTurn = currentTurn;
        currentLetter = "X";
        gameInProgress = true;
        currentMove = -1;
    }
}