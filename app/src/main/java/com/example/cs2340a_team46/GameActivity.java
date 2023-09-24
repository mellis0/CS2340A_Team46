package com.example.cs2340a_team46;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.game_screen);

        String name = getIntent().getStringExtra("name");
        int difficulty = getIntent().getIntExtra("difficulty", 0);
        int character = getIntent().getIntExtra("character", 0);

        //Name
        TextView nameText = findViewById(R.id.name);
        nameText.setText("Name: " + name);

        //Difficulty
        String diffText;
        TextView difficultyText = findViewById(R.id.difficulty);
        if (difficulty == 1) {
            diffText = "Easy";
        } else if (difficulty == 2) {
            diffText = "Normal";
        } else {
            diffText = "Hard";
        }
        difficultyText.setText("Difficulty: " + diffText);

        //Health
        TextView health = findViewById(R.id.health);
        int hp;
        if (diffText.equals("Easy")) {
            hp = 150;
        } else if (diffText.equals("Normal")) {
            hp = 100;
        } else {
            hp = 50;
        }
        health.setText("Health: " + String.valueOf(hp));

        //Image
        ImageView avatar = findViewById(R.id.avatar);
        if (character == 1) {
            avatar.setImageResource(R.drawable.angel);
        } else if (character == 2) {
            avatar.setImageResource(R.drawable.knight);
        } else if (character == 3) {
            avatar.setImageResource(R.drawable.lizard);
        }

        //Game Screen to End Screen Button
        Button endScreen = findViewById(R.id.gs_es);
        endScreen.setOnClickListener(v -> {
            Intent end = new Intent(GameActivity.this, EndActivity.class);
            startActivity(end);
            finish();
        });
    }
}
