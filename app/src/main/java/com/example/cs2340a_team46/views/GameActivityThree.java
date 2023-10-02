package com.example.cs2340a_team46.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.cs2340a_team46.R;


public class GameActivityThree extends GameActivityView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayHUD(R.layout.game_screen_3);

        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(v -> {
            Intent end = new Intent(GameActivityThree.this, EndActivity.class);
            startActivity(end);
            finish();
        });
    }
}
