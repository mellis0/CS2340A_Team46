package com.example.cs2340a_team46.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.models.LeaderboardEntry;
import com.example.cs2340a_team46.viewmodels.GameViewModel;
import com.example.cs2340a_team46.models.ScoreModel;
import com.example.cs2340a_team46.viewmodels.LeaderboardViewModel;

// Unused imports, commented to appease checkstyle
//import android.widget.EditText;
//import androidx.annotation.Nullable;
//import androidx.lifecycle.Observer;
//import com.example.cs2340a_team46.models.Player;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class EndActivity extends AppCompatActivity {

    private LeaderboardViewModel leaderboardViewModel;
    private TextView leaderboardTitle;
    private TextView entryOne;
    private TextView entryTwo;
    private TextView entryThree;
    private TextView entryFour;
    private TextView entryFive;
    private TextView recentAttempt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.end_screen);
        com.example.cs2340a_team46.viewmodels.GameViewModel.endScoreCountdown();

        leaderboardViewModel = new ViewModelProvider(this).get(LeaderboardViewModel.class);


        // retrieve latest player attempt
        String playerName = GameViewModel.getPlayerName();
        int playerScore = ScoreModel.getCurrentScore();
        Date dateTime = new Date();



        LeaderboardEntry latestAttempt = new LeaderboardEntry(playerName, playerScore, dateTime);

        // Check if the latest attempt qualifies for the leaderboard, if so add it
        if (leaderboardViewModel.isAttemptQualifiedForLeaderboard(latestAttempt)) {
            leaderboardViewModel.addEntry(latestAttempt);
        }

        // display leaderboard
        List<LeaderboardEntry> leaderboardData = leaderboardViewModel.getLeaderboardData();

        leaderboardTitle = findViewById(R.id.leaderboardTitle);
        if (playerScore == 0) {
            leaderboardTitle.setText("game over");
        }
//        leaderboardTitle.setText(" "+playerScore);

        entryOne = findViewById(R.id.leaderboardEntry1);
        entryTwo = findViewById(R.id.leaderboardEntry2);
        entryThree = findViewById(R.id.leaderboardEntry3);
        entryFour = findViewById(R.id.leaderboardEntry4);
        entryFive = findViewById(R.id.leaderboardEntry5);
        recentAttempt = findViewById(R.id.recentattempt);


        if (leaderboardData.size() == 1) {
            entryOne.setText(formatLeaderboardEntry(leaderboardData.get(0)));
            recentAttempt.setText("Most recent attempt: " + formatLeaderboardEntry(latestAttempt));
        } else if (leaderboardData.size() == 2) {
            entryOne.setText(formatLeaderboardEntry(leaderboardData.get(0)));
            entryTwo.setText(formatLeaderboardEntry(leaderboardData.get(1)));
            recentAttempt.setText("Most recent attempt: " + formatLeaderboardEntry(latestAttempt));
        } else if (leaderboardData.size() == 3) {
            entryOne.setText(formatLeaderboardEntry(leaderboardData.get(0)));
            entryTwo.setText(formatLeaderboardEntry(leaderboardData.get(1)));
            entryThree.setText(formatLeaderboardEntry(leaderboardData.get(2)));
            recentAttempt.setText("Most recent attempt: " + formatLeaderboardEntry(latestAttempt));
        } else if (leaderboardData.size() == 4) {
            entryOne.setText(formatLeaderboardEntry(leaderboardData.get(0)));
            entryTwo.setText(formatLeaderboardEntry(leaderboardData.get(1)));
            entryThree.setText(formatLeaderboardEntry(leaderboardData.get(2)));
            entryFour.setText(formatLeaderboardEntry(leaderboardData.get(3)));
            recentAttempt.setText("Most recent attempt: " + formatLeaderboardEntry(latestAttempt));
        } else {
            entryOne.setText(formatLeaderboardEntry(leaderboardData.get(0)));
            entryTwo.setText(formatLeaderboardEntry(leaderboardData.get(1)));
            entryThree.setText(formatLeaderboardEntry(leaderboardData.get(2)));
            entryFour.setText(formatLeaderboardEntry(leaderboardData.get(3)));
            entryFive.setText(formatLeaderboardEntry(leaderboardData.get(4)));
            recentAttempt.setText("Most recent attempt: " + formatLeaderboardEntry(latestAttempt));
        }



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

    // Helper method to format leaderboard entry for display
    private String formatLeaderboardEntry(LeaderboardEntry entry) {
        return entry.getPlayerName() + " - Score: " + entry.getScore() + " - "
                + formatDate(entry.getDateTime());
    }


    public String formatDate(Date date) {
        // Define the desired date and time format
        String pattern = "MM/dd/yyyy HH:mm:ss";

        // Create a SimpleDateFormat object with the pattern and the desired locale
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.US);

        // Format the date and time and return it as a string
        return simpleDateFormat.format(date);
    }
}
