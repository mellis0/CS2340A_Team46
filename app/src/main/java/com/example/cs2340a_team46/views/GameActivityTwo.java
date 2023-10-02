package com.example.cs2340a_team46.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340a_team46.R;


public class GameActivityTwo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.game_screen_2);

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
            Intent thirdScreen = new Intent(GameActivityTwo.this, GameActivityThree.class);
//            thirdScreen.putExtra("name", name);
//            thirdScreen.putExtra("difficulty", difficulty);
//            thirdScreen.putExtra("character", character);

            startActivity(thirdScreen);
            finish();
        });
        //Game Screen to End Screen Button
//        Button endScreen = findViewById(R.id.gs_es);
//        endScreen.setOnClickListener(v -> {
//            Intent end = new Intent(GameActivity.this, EndActivity.class);
//            startActivity(end);
//            finish();
//        });
    }
}
