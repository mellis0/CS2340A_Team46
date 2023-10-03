package com.example.cs2340a_team46.models;

import java.util.Date;

public class LeaderboardEntry implements Comparable<LeaderboardEntry> {
    private String playerName;
    private int score;
    private Date date;

    public LeaderboardEntry(String playerName, int score, Date date) {
        this.playerName = playerName;
        this.score = score;
        this.date = date;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public Date getDate() {
        return date;
    }



    @Override
    public int compareTo(LeaderboardEntry another) {
        return Integer.compare(this.score, another.score);
    }
}

