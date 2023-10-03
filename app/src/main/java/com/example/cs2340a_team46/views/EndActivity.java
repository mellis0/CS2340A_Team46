package com.example.cs2340a_team46.views;

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

        Button exitBtn = findViewById(R.id.exitButton);

        exitBtn.setOnClickListener(v -> {
            EndActivity.this.finish();
            System.exit(0);
        });

        // Retrieve the leaderboard entries
        Leaderboard leaderboard = Leaderboard.getInstance();
        List<LeaderboardEntry> entries = leaderboard.getEntries();

        // Create an adapter to display the entries in a ListView
        ArrayAdapter<LeaderboardEntry> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, entries);

        // Bind the adapter to the ListView
        ListView leaderboardListView = findViewById(R.id.leaderboardListView);
        leaderboardListView.setAdapter(adapter);
    }
}
