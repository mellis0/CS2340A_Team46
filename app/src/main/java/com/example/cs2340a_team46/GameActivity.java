package com.example.cs2340a_team46;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GameActivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        //Game Screen Temp: Waiting on Config Screen
        //Assumes Game is currently on Game Screen
        super.onCreate(savedInstanceState);
        Button GStoESBtn = findViewById(R.id.gs_es);
        String difficulty = getIntent().getStringExtra("difficulty");
        String name = getIntent().getStringExtra("name");

        EditText difficultyText = findViewById(R.id.difficulty);
        difficultyText.setText(difficulty);

        EditText nameText = findViewById(R.id.charName);
        nameText.setText(name);

        EditText health = findViewById(R.id.health);
        health.setText("100");

        GStoESBtn.setOnClickListener(v -> {
            Intent end = new Intent(GameActivity.this, EndActivity.class); //Change according to end class
            startActivity(end);
            finish();
        });


    }
}
