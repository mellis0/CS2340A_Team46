package com.example.cs2340a_team46.views;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cs2340a_team46.R;


public class GameActivityOne extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.game_screen_1);

        String name = com.example.cs2340a_team46.viewmodels.GameViewModel.getPlayerName();;
        String difficulty = com.example.cs2340a_team46.viewmodels.GameViewModel.getDifficulty();
        int character = com.example.cs2340a_team46.viewmodels.GameViewModel.getCharacter();
        int hp = com.example.cs2340a_team46.viewmodels.GameViewModel.getPlayerHealth();

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


        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(v -> {
            Intent secondScreen = new Intent(GameActivityOne.this, GameActivityTwo.class);
//            secondScreen.putExtra("name", name);
//            secondScreen.putExtra("difficulty", difficulty);
//            secondScreen.putExtra("character", character);
            startActivity(secondScreen);
            finish();
        });
    }
}
