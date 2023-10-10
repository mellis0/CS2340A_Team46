package com.example.cs2340a_team46.views;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.models.Leaderboard;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.start_screen);
        Button startBtn = findViewById(R.id.startButton);
        Button exitBtn = findViewById(R.id.exitButton);

        // Reset the leaderboard when the app starts
        Leaderboard leaderboard = Leaderboard.getInstance();
        leaderboard.reset();


        startBtn.setOnClickListener(v -> {
            Intent game = new Intent(MainActivity.this, ConfigActivity.class);
            startActivity(game);
            finish();
        });

        exitBtn.setOnClickListener(v -> {
            MainActivity.this.finish();
            System.exit(0);
        });
    }
}
