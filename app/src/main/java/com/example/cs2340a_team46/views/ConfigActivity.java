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
import com.example.cs2340a_team46.viewmodels.GameViewModel;

public class ConfigActivity extends AppCompatActivity {
    private RadioGroup characterRadioGroup;
    private RadioGroup difficultyRadioGroup;
    private ImageView imageView;
    private EditText nameEditText;
    private int difficulty;
    private int character;

    public static String validateInput(String enteredName, int enteredDifficulty, int enteredCharacter) {
        enteredName = enteredName.trim();
        if (enteredName.isEmpty()) {
            // Display a message if the name is empty
            return "Please enter a name";
        }
        if (!(3 >= enteredDifficulty && enteredDifficulty >= 1)) { // difficulty must be between 1 & 3
            return "Please select difficulty";
        }
        if (!(3 >= enteredCharacter && enteredCharacter >= 1)) { // enteredCharacter must be between 1 & 3
            return "Please select a character";
        }
        return null;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.config_screen);

        nameEditText = findViewById(R.id.editText);

        Button startGameBtn = findViewById(R.id.startGameButton);
        startGameBtn.setOnClickListener(v -> {
            String enteredName = nameEditText.getText().toString().trim();
            int enteredDifficulty = difficulty; // copy these vals so that they are not modified by a race condition
            int enteredCharacter = character;
            String errMsg = validateInput(enteredName, enteredDifficulty, enteredCharacter);
            if (errMsg != null) { // if errMsg is not the empty string, then there is an error, so display that message
                Toast.makeText(ConfigActivity.this,
                        errMsg,
                        Toast.LENGTH_SHORT).show();
            } else {

                Intent game = new Intent(ConfigActivity.this, GameActivityOne.class);
                GameViewModel.setPlayerName(enteredName);
                GameViewModel.setDifficulty(enteredDifficulty);
                GameViewModel.setPlayerHealth(enteredDifficulty);
                GameViewModel.setCharacter(enteredCharacter);

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
