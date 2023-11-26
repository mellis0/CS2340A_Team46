package com.example.cs2340a_team46.models;

public class Player extends Agent {
    private static volatile Player instance;
    private static final MovementBehavior DEFAULT_MOVEMENT_BEHAVIOR = new NormalMovement();
    public static final int EASY_HEALTH = 150;
    public static final int NORMAL_HEALTH = 100;
    public static final int HARD_HEALTH = 50;

    private int difficulty;
    private String playerName;

    // getter and setter for difficulty
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    public int getDifficulty() {
        return difficulty;
    }

    public String getDifficultyString() {
        switch (this.difficulty) {
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
    public int getDifficultyInt() {
        return this.difficulty;
    }

    // getter and setter for player name
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public String getPlayerName() {
        return playerName;
    }

    // getter and setter for sprite
    public void setSprite(int sprite) {
        this.sprite = sprite;
    }
    public int getSprite() {
        return sprite;
    }

    // made thread safe
    public static Player getInstance() {
        if (instance == null) {
            synchronized (Player.class) {
                if (instance == null) {
                    instance = new Player();
                    instance.location = new Location(500.0, 500.0); // spawn location
                    instance.movementBehavior = DEFAULT_MOVEMENT_BEHAVIOR;
                }
            }
        }
        return instance;
    }

}
