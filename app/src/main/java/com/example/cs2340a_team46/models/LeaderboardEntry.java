package com.example.cs2340a_team46.models;

import java.util.Date;

public class LeaderboardEntry implements Comparable<LeaderboardEntry> {
    private String playerName;
    private int score;
    private Date dateTime;

    public LeaderboardEntry(String playerName, int score, Date dateTime) {
        this.playerName = playerName;
        this.score = score;
        this.dateTime = dateTime;
    }
    @Override
    public int compareTo(LeaderboardEntry other) {
        // Compare attempts based on scores
        return Integer.compare(this.score, other.score);
    }
    // Getter methods for playerName, score, and dateTime

    public String getPlayerName() {
        return playerName;
    }
    public int getScore() {
        return score;
    }
    public Date getDateTime() {
        return dateTime;
    }
}

