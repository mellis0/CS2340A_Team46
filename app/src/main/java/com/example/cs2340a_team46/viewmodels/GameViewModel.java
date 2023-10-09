package com.example.cs2340a_team46.viewmodels;

import android.os.CountDownTimer;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.model.ScoreModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.models.Player;


public class GameViewModel extends ViewModel {
    // we shouldn't need these static vars anymore b/c this info is stored in the Player object
//    private static int playerHealth;
//    private static String difficulty;
//    private static String playerName;
//    private static int character;
//    private static MutableLiveData<Integer> score = new MutableLiveData<>();;
    private static ScoreModel scoreModel = new ScoreModel();;
    private static LiveData<Integer> score = scoreModel.getScore();
    private static final int countdownDuration = 100000;
    private static final int countdownInterval = 1000;
    private static CountDownTimer countDownTimer = new CountDownTimer(countdownDuration, countdownInterval) {
        @Override
        public void onTick(long millisUntilFinished) {
            GameViewModel.scoreModel.setScore(score.getValue() - 1);
        }
        @Override
        public void onFinish() {

        }
    };

    private static Player player = Player.getInstance();
    public static void setPlayerHealth(int difficultyVal) {
        if (difficultyVal == 1) {
            player.playerHealth = 150;
            // GameViewModel.playerHealth = 150;
        } else if (difficultyVal == 2) {
            player.playerHealth = 100;
            // GameViewModel.playerHealth = 100;
        } else if (difficultyVal == 3) {
            player.playerHealth = 50;
            // GameViewModel.playerHealth = 50;
        } else {
            throw new IllegalArgumentException("Difficulty must be 1, 2, or 3");
        }
    }

    public static void setDifficulty(int difficultyVal) {
        if (difficultyVal == 1) {
            player.difficulty = "Easy";
            // GameViewModel.difficulty = "Easy";
        } else if (difficultyVal == 2) {
            player.difficulty = "Normal";
            // GameViewModel.difficulty = "Normal";
        } else if (difficultyVal == 3) {
            player.difficulty = "Hard";
            // GameViewModel.difficulty = "Hard";
        } else {
            throw new IllegalArgumentException("Difficulty must be 1, 2, or 3");
        }
    }

    public static void setPlayerName(String name) {
        player.playerName = name;
        // GameViewModel.playerName = name;
    }

    public static void setCharacter(int characterRadioButton) {
        if (characterRadioButton == 1) {
            player.character = R.drawable.angel;
            // GameViewModel.character = R.drawable.angel;
        } else if (characterRadioButton == 2) {
            player.character = R.drawable.knight;
            // GameViewModel.character = R.drawable.knight;
        } else if (characterRadioButton == 3) {
            player.character = R.drawable.lizard;
            // GameViewModel.character = R.drawable.lizard;
        } else {
            throw new IllegalArgumentException("characterRadioButton must be 1, 2, or 3");
        }
    }

    public static int getPlayerHealth() {
        return player.playerHealth;
    }

    public static String getDifficulty() {
        return player.difficulty;
    }

    public static String getPlayerName() {
        return player.playerName;
    }

    public static int getCharacter() {
        return player.character;
    }
    public static LiveData<Integer> getPlayerScore() {
        return score;
    }

    public static void startScoreCountdown() {
        GameViewModel.scoreModel.setScore(100);
        countDownTimer.start();
    }
    public static void endScoreCountdown() {
        countDownTimer.cancel();
    }
}
