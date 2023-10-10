package com.example.cs2340a_team46.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leaderboard {
    private volatile static Leaderboard instance;
    private List<LeaderboardEntry> leaderboardData;
    private int maxAttemptsToShow = 5;

    private Leaderboard() {
        leaderboardData = new ArrayList<>();
    }

    public static Leaderboard getInstance() {
        if (instance == null) {
            instance = new Leaderboard();
        }
        return instance;
    }

//    moved to viewModel
//    public void addEntry(LeaderboardEntry entry) {
//        leaderboardData.add(entry);
//        // Sort the leaderboard in descending order based on scores
//        Collections.sort(leaderboardData, Collections.reverseOrder());
//        // Truncate the list to show a maximum of maxAttemptsToShow attempts
//        if (leaderboardData.size() > maxAttemptsToShow) {
//            leaderboardData.subList(maxAttemptsToShow, leaderboardData.size()).clear();
//        }
//    }



    public List<LeaderboardEntry> getLeaderboardData() {
        return leaderboardData;
    }

//    moved to ViewModel
//    public boolean isAttemptQualifiesForLeaderboard(LeaderboardEntry entry) {
//        // Check if the attempt qualifies for the leaderboard
//        return leaderboardData.isEmpty() || leaderboardData.size() < maxAttemptsToShow
//                || entry.compareTo(leaderboardData.get(leaderboardData.size() - 1)) > 0;
//    }
}
