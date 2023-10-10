package com.example.cs2340a_team46.models;

import android.os.CountDownTimer;

import com.example.cs2340a_team46.R;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.LiveData;

public class ScoreModel {
    private static MutableLiveData<Integer> score = new MutableLiveData<>();
    public LiveData<Integer> getScore() {
        return score;
    }

    public static int getCurrentScore() {
        return score.getValue();
    }



    public void setScore(int newScore) {
        if (newScore < 0) return;
        score.setValue(newScore);
    }
}
