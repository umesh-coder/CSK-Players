package com.example.cskplayers;

import android.graphics.Bitmap;

public class PlayerModel {


    private String name;
    private String born;
    private String role;
    private String battingStyle;
    private String bowlingStyle;
    private String nationality;
    private String iplDebut;
    private String auctionPrice;
    private String matches;
    private String runs;
    private String wickets;
    private String fifties;
    private String hundreds;
    private String highestScore;
    private Bitmap playerImg;


    public PlayerModel(String name, String born, String role, String battingStyle, String bowlingStyle, String nationality, String iplDebut, String auctionPrice, String matches, String runs, String wickets, String fifties, String hundreds, String highestScore, Bitmap playerImg) {
        this.name = name;
        this.born = born;
        this.role = role;
        this.battingStyle = battingStyle;
        this.bowlingStyle = bowlingStyle;
        this.nationality = nationality;
        this.iplDebut = iplDebut;
        this.auctionPrice = auctionPrice;
        this.matches = matches;
        this.runs = runs;
        this.wickets = wickets;
        this.fifties = fifties;
        this.hundreds = hundreds;
        this.highestScore = highestScore;
        this.playerImg = playerImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBattingStyle() {
        return battingStyle;
    }

    public void setBattingStyle(String battingStyle) {
        this.battingStyle = battingStyle;
    }

    public String getBowlingStyle() {
        return bowlingStyle;
    }

    public void setBowlingStyle(String bowlingStyle) {
        this.bowlingStyle = bowlingStyle;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIplDebut() {
        return iplDebut;
    }

    public void setIplDebut(String iplDebut) {
        this.iplDebut = iplDebut;
    }

    public String getAuctionPrice() {
        return auctionPrice;
    }

    public void setAuctionPrice(String auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    public String getMatches() {
        return matches;
    }

    public void setMatches(String matches) {
        this.matches = matches;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    public String getWickets() {
        return wickets;
    }

    public void setWickets(String wickets) {
        this.wickets = wickets;
    }

    public String getFifties() {
        return fifties;
    }

    public void setFifties(String fifties) {
        this.fifties = fifties;
    }

    public String getHundreds() {
        return hundreds;
    }

    public void setHundreds(String hundreds) {
        this.hundreds = hundreds;
    }

    public String getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(String highestScore) {
        this.highestScore = highestScore;
    }

    public Bitmap getPlayerImg() {
        return playerImg;
    }

    public void setPlayerImg(Bitmap playerImg) {
        this.playerImg = playerImg;
    }



}
