package com.example.cs2340a_team46.models;

import java.util.ArrayList;
import java.util.List;

// Unused import, commented to appease checkstyle
//import java.util.Collections;


public class Leaderboard {
    private static volatile Leaderboard instance;
    private static List<LeaderboardEntry> leaderboardData;
    private static int size = 0;

    private Leaderboard() {
        leaderboardData = new ArrayList<>();
    }

    public static Leaderboard getInstance() {
        if (instance == null) {
            instance = new Leaderboard();
        }
        return instance;
    }



    public List<LeaderboardEntry> getLeaderboardData() {
        return leaderboardData;
    }

    public static int getLeaderboardSize() {
        return size;
    }
    public static void incrementLeaderboardSize() {
        size++;
    }

    public void setLeaderboardSize(int newSize) {
        size = newSize;
    }

    // method to reset the leaderboard entries
    public static void reset() {
        leaderboardData.clear();
    }
}
