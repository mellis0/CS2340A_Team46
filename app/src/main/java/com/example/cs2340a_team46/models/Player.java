package com.example.cs2340a_team46.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.example.cs2340a_team46.R;

public class Player {
    private static volatile Player instance;
    private int playerHealth;
    private int difficulty;
    private String playerName;
    private int character;
    private double charX=500;
    private double charY=500;
    private Context context;

    private double speed = 0.01;




    // getter and setter for health
    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }
    public int getPlayerHealth() {
        return playerHealth;
    }

    // getter and setter for difficulty
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    public int getDifficulty() {
        return difficulty;
    }

    // getter and setter for player name
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public String getPlayerName() {
        return playerName;
    }

    // getter and setter for character
    public void setCharacter(int character) {
        this.character = character;
    }
    public int getCharacter() {
        return character;
    }


    public void setCharX(double aCharX) {
        charX = aCharX;
    }
    public void setCharY(double aCharY) {
        charY = aCharY;
    }
    public double getCharX() {
        return charX;
    }
    public double getCharY() {
        return charY;
    }


    public void updateLoc(double x, double y, double distance) {
        Log.d("xValue", "is " + x);
        Log.d("yValue", "is " + y);
        double xSpeed = (x-275)/5;
        double ySpeed = (y-1200)/5;
        //check x case first
        if (!Tilemap.getIfCollide(charX+xSpeed, charY)){
            charX += xSpeed;
        }
        if (!Tilemap.getIfCollide(charX, charY+ySpeed)){
            charY += ySpeed;
        }

    }

    // made thread safe
    public static Player getInstance() {
        if (instance == null) {
            synchronized (Player.class) {
                if (instance == null) {
                    instance = new Player();
                }
            }
        }
        return instance;
    }

}
