package com.example.cs2340a_team46.models;

public class Player {
    private volatile static Player instance;
    public static int playerHealth;
    public static String difficulty;
    public static String playerName;
    public static int character;

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
