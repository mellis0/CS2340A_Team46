package com.example.cs2340a_team46.models;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

    public class Leaderboard {
        private static Leaderboard instance;
        private List<LeaderboardEntry> entries;

        private Leaderboard() {
            entries = new ArrayList<>();
        }

        public static Leaderboard getInstance() {
            if (instance == null) {
                instance = new Leaderboard();
            }
            return instance;
        }

        public void addEntry(String playerName, int score) {
            LeaderboardEntry entry = new LeaderboardEntry(playerName, score, new Date());
            entries.add(entry);
            Collections.sort(entries, Collections.reverseOrder());
        }

        public List<LeaderboardEntry> getEntries() {
            return entries;
        }
    }


