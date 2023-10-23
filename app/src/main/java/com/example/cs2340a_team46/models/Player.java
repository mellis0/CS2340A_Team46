package com.example.cs2340a_team46.models;

import android.content.Context;

import java.util.ArrayList;
import java.util.Observable;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.example.cs2340a_team46.R;

public class Player extends Observable {
    private static volatile Player instance;
    private static final MovementBehavior defaultMovementBehavior = new NormalMovement();
    private int playerHealth;
    private int difficulty;
    private String playerName;
    private int character;
    private double charX=500;
    private double charY=500;
    private Context context;
    private MovementBehavior movementBehavior;

    private double speed = 0.01;


    public void setMovementBehavior(MovementBehavior mb) {
        this.movementBehavior = mb;
    }

    public MovementBehavior getMovementBehavior() {
        return this.movementBehavior;
    }

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

    public String getDifficultyString() {
        switch(this.difficulty) {
            case 1:
                return "Easy";
            case 2:
                return "Normal";
            case 3:
                return "Hard";
            default:
                throw new RuntimeException("Player.difficulty can only be 1, 2, or 3");
        }
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


    public void updateLoc(double joystick_x, double joystick_y, boolean collideCheck) {
        double[] locationTupleOfDoubles = this.movementBehavior.move(charX, charY, joystick_x, joystick_y, collideCheck);

        charX = locationTupleOfDoubles[0];
        charY = locationTupleOfDoubles[1];

        ArrayList<Float> locationTuple = new ArrayList<Float>();
        locationTuple.add((float) charX);
        locationTuple.add((float) charY);
        setChanged();
        notifyObservers(locationTuple);
    }

    // made thread safe
    public static Player getInstance() {
        if (instance == null) {
            synchronized (Player.class) {
                if (instance == null) {
                    instance = new Player();
                    instance.movementBehavior = defaultMovementBehavior;
                }
            }
        }
        return instance;
    }

}
