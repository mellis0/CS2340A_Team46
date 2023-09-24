package com.example.cs2340a_team46;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.game_screen);

        String name = getIntent().getStringExtra("name");
        String difficulty = getIntent().getStringExtra("difficulty");
        String character = getIntent().getStringExtra("Character");

        //Name
        TextView nameText = findViewById(R.id.name);
        nameText.setText("Name: " + name);

        //Difficulty
        TextView difficultyText = findViewById(R.id.difficulty);
        if (difficulty.equals("1")) {
            difficulty = "Easy";
        } else if (difficulty.equals("2")) {
            difficulty = "Normal";
        } else {
            difficulty = "Hard";
        }
        difficultyText.setText(difficulty);

        //Health
        TextView health = findViewById(R.id.health);
        int hp;
        if (difficulty.equals("Easy")) {
            hp = 150;
        } else if (difficulty.equals("Normal")) {
            hp = 100;
        } else {
            hp = 50;
        }
        health.setText(hp);

        //Image
        ImageView avatar = findViewById(R.id.avatar);
        if (character.equals("1")) {
            avatar.setImageResource(R.drawable.angel);
        } else if (character.equals("2")) {
            avatar.setImageResource(R.drawable.knight);
        } else {
            avatar.setImageResource(R.drawable.lizard);
        }

        //Game Screen to End Screen Button
        Button GStoESBtn = findViewById(R.id.gs_es);
        GStoESBtn.setOnClickListener(v -> {
            //Intent end = new Intent(GameActivity.this, EndActivity.class); //Change according to end class
            //startActivity(end);
            finish();
        });
    }
}
