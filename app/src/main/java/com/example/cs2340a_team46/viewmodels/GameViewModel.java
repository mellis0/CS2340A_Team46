package com.example.cs2340a_team46.viewmodels;

import android.widget.TextView;

import com.example.cs2340a_team46.R;

public class GameViewModel {
    private static int playerHealth;
    private static String difficulty;
    private static String playerName;
    private static int character;

//    private static Player player = null; // need to implement player singleton model first. Once implemented, we might not need the static vars above


    public static void setPlayerHealth(int difficultyVal) {
        if (difficultyVal == 1) {
            GameViewModel.playerHealth = 150;
        } else if (difficultyVal == 2) {
            GameViewModel.playerHealth = 100;
        } else if (difficultyVal == 3) {
            GameViewModel.playerHealth = 50;
        } else {
            throw new IllegalArgumentException("Difficulty must be 1, 2, or 3");
        }
    }

    public static void setDifficulty(int difficultyVal) {
        if (difficultyVal == 1) {
            GameViewModel.difficulty = "Easy";
        } else if (difficultyVal == 2) {
            GameViewModel.difficulty = "Normal";
        } else if (difficultyVal == 3) {
            GameViewModel.difficulty = "Hard";
        } else {
            throw new IllegalArgumentException("Difficulty must be 1, 2, or 3");
        }
    }

    public static void setPlayerName(String name) {
        GameViewModel.playerName = name;
    }

    public static void setCharacter(int characterRadioButton) {
        if (characterRadioButton == 1) {
            GameViewModel.character = R.drawable.angel;
        } else if (characterRadioButton == 2) {
            GameViewModel.character = R.drawable.knight;
        } else if (characterRadioButton == 3) {
            GameViewModel.character = R.drawable.lizard;
        } else {
            throw new IllegalArgumentException("characterRadioButton must be 1, 2, or 3");
        }
    }

    public static int getPlayerHealth() {
        return playerHealth;
    }

    public static String getDifficulty() {
        return difficulty;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static int getCharacter() {
        return character;
    }
}
