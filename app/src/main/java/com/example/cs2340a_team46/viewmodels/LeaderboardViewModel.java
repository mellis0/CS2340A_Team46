package com.example.cs2340a_team46.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.cs2340a_team46.models.Leaderboard;
import com.example.cs2340a_team46.models.LeaderboardEntry;
import com.example.cs2340a_team46.models.ScoreModel;

// Comment unused import to appease checkstyle
// import androidx.lifecycle.Observer;

import java.util.Collections;
import java.util.List;

public class LeaderboardViewModel extends ViewModel {

    private ScoreModel scoreModel;
    private static Leaderboard leaderboard = Leaderboard.getInstance();

    public LeaderboardViewModel() {
        leaderboard = Leaderboard.getInstance();
    }

    public static List<LeaderboardEntry> getLeaderboardData() {
        return leaderboard.getLeaderboardData();
    }

    public int getCurrentScore() {
        return scoreModel.getCurrentScore();
    }

    public void incrementLeaderboardSize() {
        Leaderboard.incrementLeaderboardSize();
    }
    public int getSize() {
        return Leaderboard.getLeaderboardSize();
    }

    public static boolean isAttemptQualifiedForLeaderboard(LeaderboardEntry entry) {
        // Check if the attempt qualifies for the leaderboard
        return leaderboard.getLeaderboardData().isEmpty()
                || leaderboard.getLeaderboardData().size() < 5
                || entry.compareTo(leaderboard.getLeaderboardData().get(
                leaderboard.getLeaderboardData().size() - 1)) > 0;
    }


    public static void addEntry(LeaderboardEntry entry) {
        leaderboard.getLeaderboardData().add(entry);
        leaderboard.incrementLeaderboardSize();
        // Sort the leaderboard in descending order based on scores
        Collections.sort(leaderboard.getLeaderboardData(), Collections.reverseOrder());
        // makes sure only five attempts show
        if (leaderboard.getLeaderboardData().size() > 5) {
            leaderboard.getLeaderboardData().subList(5,
                    leaderboard.getLeaderboardData().size()).clear();

        }
    }

    public static void reset() {
        Leaderboard.reset();
    }


}

