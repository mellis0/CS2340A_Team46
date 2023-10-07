package com.example.cs2340a_team46.viewmodels;

import android.os.CountDownTimer;

import com.example.cs2340a_team46.R;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GameViewModel extends ViewModel {
    private static int playerHealth;
    private static String difficulty;
    private static String playerName;
    private static int character;
    private static MutableLiveData<Integer> score = new MutableLiveData<>();;
    private static final int countdownDuration = 100000;
    private static final int countdownInterval = 1000;

// need to implement player singleton model first. Once implemented, we might not need the static vars above
//    private static Player player = null;

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
    public static MutableLiveData<Integer> getPlayerScore() {
        return score;
    }

    public static void startScoreCountdown() {
        CountDownTimer countDownTimer = new CountDownTimer(countdownDuration, countdownInterval) {
            @Override
            public void onTick(long millisUntilFinished) {
                GameViewModel.score.setValue(GameViewModel.score.getValue()-1);
            }
            @Override
            public void onFinish() {
            }
        };
        GameViewModel.score.setValue(100);
        countDownTimer.start();
        return;
    }
}
