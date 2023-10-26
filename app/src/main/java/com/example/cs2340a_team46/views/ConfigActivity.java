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
import com.example.cs2340a_team46.models.Player;
import com.example.cs2340a_team46.viewmodels.GameViewModel;

public class ConfigActivity extends AppCompatActivity {
    private RadioGroup characterRadioGroup;
    private RadioGroup difficultyRadioGroup;
    private ImageView imageView;
    private EditText nameEditText;
    private int difficulty;
    private int character;
    private Player player = Player.getInstance();

    public static boolean validName(String enteredName) {
        // this input will always be already trimmed, this is just for testing
        // note also that .trim() returns a new string and the original String object passed as an
        // argument is unchanged
        enteredName = enteredName.trim();
        return !enteredName.isEmpty();
    }

    public static boolean validDifficulty(int enteredDifficulty) {
        // difficulty must be between 1 & 3
        return (3 >= enteredDifficulty && enteredDifficulty >= 1);
    }

    public static boolean validCharacter(int enteredCharacter) {
        // enteredCharacter must be between 1 & 3
        return (3 >= enteredCharacter && enteredCharacter >= 1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.config_screen);

        nameEditText = findViewById(R.id.editText);

        Button startGameBtn = findViewById(R.id.startGameButton);
        startGameBtn.setOnClickListener(v -> {
            String enteredName = nameEditText.getText().toString().trim();
            // copy these vals so that they are not modified by a race condition
            int enteredDifficulty = difficulty;
            int enteredCharacter = character;
            if (!validName(enteredName)) {
                Toast.makeText(ConfigActivity.this,
                        "Please enter a name",
                        Toast.LENGTH_SHORT).show();
            } else if (!validDifficulty(enteredDifficulty)) {
                Toast.makeText(ConfigActivity.this,
                        "Please select difficulty",
                        Toast.LENGTH_SHORT).show();
            } else if (!validCharacter(enteredCharacter)) {
                Toast.makeText(ConfigActivity.this,
                        "Please select a character",
                        Toast.LENGTH_SHORT).show();
            } else {

                Intent game = new Intent(ConfigActivity.this, GameActivity.class);

                GameViewModel.setPlayerName(enteredName);
                GameViewModel.setDifficulty(enteredDifficulty);
                GameViewModel.setPlayerHealth(enteredDifficulty);
                GameViewModel.setCharacter(enteredCharacter);
                GameViewModel.startScoreCountdown();

                startActivity(game);
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
