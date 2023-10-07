package com.example.cs2340a_team46.views;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import android.widget.EditText;

import com.example.cs2340a_team46.R;

public class ConfigActivity extends AppCompatActivity {
    private RadioGroup characterRadioGroup;
    private RadioGroup difficultyRadioGroup;
    private ImageView imageView;
    private EditText nameEditText;
    private int difficulty;
    private int character;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.config_screen);

        nameEditText = findViewById(R.id.editText);

        Button startGameBtn = findViewById(R.id.startGameButton);

        startGameBtn.setOnClickListener(v -> {
            String enteredName = nameEditText.getText().toString().trim();
            if (enteredName.isEmpty()) {
                // Display a message if the name is empty
                Toast.makeText(ConfigActivity.this,
                        "Please enter a name.",
                        Toast.LENGTH_SHORT).show();
            } else if (difficulty == 0) {
                Toast.makeText(ConfigActivity.this,
                        "Please select difficulty.",
                        Toast.LENGTH_SHORT).show();
            } else if (character == 0) {
                Toast.makeText(ConfigActivity.this,
                        "Please select a character.",
                        Toast.LENGTH_SHORT).show();
            } else {

                Intent game = new Intent(ConfigActivity.this, GameActivityOne.class);
                com.example.cs2340a_team46.viewmodels.GameViewModel.setPlayerName(enteredName);
                com.example.cs2340a_team46.viewmodels.GameViewModel.setDifficulty(difficulty);
                com.example.cs2340a_team46.viewmodels.GameViewModel.setPlayerHealth(difficulty);
                com.example.cs2340a_team46.viewmodels.GameViewModel.setCharacter(character);
//                game.putExtra("name", enteredName);
//                game.putExtra("difficulty", difficulty);
//                game.putExtra("character", character);
                com.example.cs2340a_team46.viewmodels.GameViewModel.startScoreCountdown();
                startActivity(game);
                finish();
            }

        });

        characterRadioGroup = findViewById(R.id.characterRadioGroup);
        imageView = findViewById(R.id.imageView);

        // Set a listener for the RadioGroup
        characterRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Handle the radio button selection
                RadioButton selectedRadioButton = findViewById(checkedId);

                if (selectedRadioButton.getId() == R.id.characterRadioOption1) {
                    imageView.setImageResource(R.drawable.angel);
                    character = 1;
                } else if (selectedRadioButton.getId() == R.id.characterRadioOption2) {
                    imageView.setImageResource(R.drawable.knight);
                    character = 2;
                } else if (selectedRadioButton.getId() == R.id.characterRadioOption3) {
                    imageView.setImageResource(R.drawable.lizard);
                    character = 3;
                }
            }
        });

        difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
        difficultyRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Handle the radio button selection
                RadioButton selectedRadioButton = findViewById(checkedId);

                if (selectedRadioButton.getId() == R.id.difficultyRadioOption1) {
                    difficulty = 1;
                } else if (selectedRadioButton.getId() == R.id.difficultyRadioOption2) {
                    difficulty = 2;
                } else if (selectedRadioButton.getId() == R.id.difficultyRadioOption3) {
                    difficulty = 3;
                }
            }
        });
    }
}
