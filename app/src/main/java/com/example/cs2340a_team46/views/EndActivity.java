package com.example.cs2340a_team46.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340a_team46.R;

public class EndActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.end_screen);
        com.example.cs2340a_team46.viewmodels.GameViewModel.endScoreCountdown();

        Button exitBtn = findViewById(R.id.exitButton);

        exitBtn.setOnClickListener(v -> {
            EndActivity.this.finish();
            System.exit(0);
        });

        Button retryButton = findViewById(R.id.retryButton);
        retryButton.setOnClickListener(v -> {
            Intent main = new Intent(EndActivity.this, MainActivity.class);
            startActivity(main);
            finish();
        });
    }
}
