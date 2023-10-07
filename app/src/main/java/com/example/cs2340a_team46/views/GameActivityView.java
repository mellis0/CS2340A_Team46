package com.example.cs2340a_team46.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.viewmodels.GameViewModel;


public class GameActivityView extends AppCompatActivity {
    private GameViewModel gameViewModel;

    protected void displayHUD(int layout) {
        getSupportActionBar().hide();
        setContentView(layout);

        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        String name = gameViewModel.getPlayerName();
        String difficulty = gameViewModel.getDifficulty();
        int character = gameViewModel.getCharacter();
        int hp = gameViewModel.getPlayerHealth();
//        LiveData<Integer> score = gameViewModel.getPlayerScore();

        //Name
        TextView nameText = findViewById(R.id.name);
        nameText.setText("Name: " + name);

        //Difficulty
        TextView difficultyText = findViewById(R.id.difficulty);
        difficultyText.setText("Difficulty: " + difficulty);

        //Health
        TextView health = findViewById(R.id.health);
        health.setText("Health: " + String.valueOf(hp));

        //Image
        ImageView avatar = findViewById(R.id.avatar);
        avatar.setImageResource(character);

        //Score
        TextView scoreText = findViewById(R.id.score);
        gameViewModel.getPlayerScore().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer newScore) {
                // Update the UI with the new score

                scoreText.setText("Score: " + String.valueOf(newScore));
            }
        });
    }

}
