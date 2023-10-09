package com.example.cs2340a_team46.models;

public class Player {
    private volatile static Player instance;
    private int playerHealth;
    private String difficulty;
    private String playerName;
    private int character;

    // getter and setter for health
    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }
    public int getPlayerHealth() {
        return playerHealth;
    }

    // getter and setter for difficulty
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public String getDifficulty() {
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

    private Player() { }

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
