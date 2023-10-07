package com.example.cs2340a_team46.views;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.cs2340a_team46.R;


public class GameActivityView extends AppCompatActivity {
    protected void displayHUD(int layout) {
        getSupportActionBar().hide();
        setContentView(layout);

        String name = com.example.cs2340a_team46.viewmodels.GameViewModel.getPlayerName();
        String difficulty = com.example.cs2340a_team46.viewmodels.GameViewModel.getDifficulty();
        int character = com.example.cs2340a_team46.viewmodels.GameViewModel.getCharacter();
        int hp = com.example.cs2340a_team46.viewmodels.GameViewModel.getPlayerHealth();
        int score = com.example.cs2340a_team46.viewmodels.GameViewModel.getPlayerScore();

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

        //Health
        TextView scoreText = findViewById(R.id.score);
        scoreText.setText("Score: " + String.valueOf(score));
    }
}
