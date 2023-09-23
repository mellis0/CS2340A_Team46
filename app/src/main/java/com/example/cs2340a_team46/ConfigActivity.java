package com.example.cs2340a_team46;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import android.widget.EditText;
public class ConfigActivity extends AppCompatActivity {
    private EditText editText;
    private TextView displayTextView;
    private String name;
    private int difficulty;
    private int health;
    private int character;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.config_screen);

        editText = findViewById(R.id.editText);
        displayTextView = findViewById(R.id.displayTextView);


        Button startGameBtn = findViewById(R.id.startGameButton);

        startGameBtn.setOnClickListener(v -> {
            Intent game = new Intent(ConfigActivity.this, GameActivity.class);
            game.putExtra("name", name);
            game.putExtra("difficulty", difficulty);
            game.putExtra("health", health);
            game.putExtra("character", character);
            startActivity(game);
            finish();
        });
    }
    public void onDisplayButtonClick(View view) {
        String userInput = editText.getText().toString();
        displayTextView.setText("User Input: " + userInput);
    }
}
