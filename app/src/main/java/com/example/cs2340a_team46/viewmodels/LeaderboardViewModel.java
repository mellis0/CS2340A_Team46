package com.example.cs2340a_team46.viewmodels;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.cs2340a_team46.models.Leaderboard;
import com.example.cs2340a_team46.models.LeaderboardEntry;
import com.example.cs2340a_team46.models.ScoreModel;

import java.util.Collections;
import java.util.List;

public class LeaderboardViewModel extends ViewModel {
    private static Leaderboard leaderboard = Leaderboard.getInstance();

    public LeaderboardViewModel() {
        leaderboard = Leaderboard.getInstance();
    }

    public List<LeaderboardEntry> getLeaderboardData() {
        return leaderboard.getLeaderboardData();
    }

    public boolean isAttemptQualifiedForLeaderboard(LeaderboardEntry entry) {
        // Check if the attempt qualifies for the leaderboard
        return leaderboard.getLeaderboardData().isEmpty()
                || leaderboard.getLeaderboardData().size() < 5
                || entry.compareTo(leaderboard.getLeaderboardData().get
                (leaderboard.getLeaderboardData().size() - 1)) > 0;
    }


    public void addEntry(LeaderboardEntry entry) {
        leaderboard.getLeaderboardData().add(entry);
        // Sort the leaderboard in descending order based on scores
        Collections.sort(leaderboard.getLeaderboardData(), Collections.reverseOrder());
        // Truncate the list to show a maximum of maxAttemptsToShow attempts
        if (leaderboard.getLeaderboardData().size() > 5) {
            leaderboard.getLeaderboardData().subList(5,
                    leaderboard.getLeaderboardData().size()).clear();
        }
    }


}

