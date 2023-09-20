package com.example.cs2340a_team46;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.start_screen);
        Button startBtn = findViewById(R.id.startButton);
        Button exitBtn = findViewById(R.id.exitButton);

        // TODO: implement transition from start screen to game
//        startBtn.setOnClickListener(v -> {
//            Intent game = new Intent(MainActivity.this, GameActivity.class);
//            startActivity(game);
//            finish();
//        });

        exitBtn.setOnClickListener(v -> {
            MainActivity.this.finish();
            System.exit(0);
        });
    }
}
