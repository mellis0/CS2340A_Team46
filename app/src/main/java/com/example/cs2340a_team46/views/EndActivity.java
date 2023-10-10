package com.example.cs2340a_team46.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.models.LeaderboardEntry;
import com.example.cs2340a_team46.viewmodels.GameViewModel;
import com.example.cs2340a_team46.models.Player;
import com.example.cs2340a_team46.models.ScoreModel;
import com.example.cs2340a_team46.viewmodels.LeaderboardViewModel;


import java.util.Date;
import java.util.List;

public class EndActivity extends AppCompatActivity {

    private LeaderboardViewModel leaderboardViewModel;
    private TextView entryOne;
    private TextView entryTwo;
    private TextView entryThree;
    private TextView entryFour;
    private TextView entryFive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.end_screen);
        com.example.cs2340a_team46.viewmodels.GameViewModel.endScoreCountdown();

        leaderboardViewModel = new ViewModelProvider(this).get(LeaderboardViewModel.class);

        // retrieve latest player attempt
        String playerName = GameViewModel.getPlayerName();
        int playerScore = ScoreModel.getScore();
        Date dateTime = new Date();

        //creating an observer to get latest score value

        final Observer<Integer> scoreObserver = new Observer<Integer>() {
            int score;
            @Override
            public void onChanged(@Nullable final Integer currentScore) {
                score = currentScore;
            }

        };

        LeaderboardEntry latestAttempt = new LeaderboardEntry(playerName, playerScore, dateTime);

        // Check if the latest attempt qualifies for the leaderboard, if so add it
        if (leaderboardViewModel.isAttemptQualifiedForLeaderboard(latestAttempt)) {
            leaderboardViewModel.addEntry(latestAttempt);
        }

        // display leaderboard
        List<LeaderboardEntry> leaderboardData = leaderboardViewModel.getLeaderboardData();

        entryOne = findViewById(R.id.leaderboardEntry1);
        entryTwo = findViewById(R.id.leaderboardEntry2);
        entryThree = findViewById(R.id.leaderboardEntry3);
        entryFour = findViewById(R.id.leaderboardEntry4);
        entryFive = findViewById(R.id.leaderboardEntry5);

        entryOne.setText(leaderboardData.get(0));



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
