package com.example.cs2340a_team46.model;

import android.os.CountDownTimer;

import com.example.cs2340a_team46.R;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.LiveData;

public class ScoreModel {
    private MutableLiveData<Integer> score = new MutableLiveData<>();
    public LiveData<Integer> getScore() {
        return score;
    }

    public void setScore(int newScore) {
        score.setValue(newScore);
    }
}
