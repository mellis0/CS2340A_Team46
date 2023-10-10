package com.example.cs2340a_team46;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.cs2340a_team46.models.Leaderboard;
import com.example.cs2340a_team46.models.LeaderboardEntry;
import com.example.cs2340a_team46.viewmodels.LeaderboardViewModel;

public class HsiehUnitTests {
    private Leaderboard leaderboard;

    @Before
    public void setUp() {
        leaderboard = Leaderboard.getInstance();
    }

    @Test
    public void testAddAttemptToLeaderboard() {
        // Create a sample attempt
        LeaderboardEntry attempt = new LeaderboardEntry("Player1", 1000, new Date());

        // Add the attempt to the leaderboard
        leaderboard.addEntry(attempt);

        // Check if the leaderboard contains the added attempt
        assertTrue(leaderboard.getLeaderboardData().contains(attempt));
    }

    @Test
    public void testLeaderboardOrder() {
        // Create multiple attempts with different scores
        LeaderboardEntry attempt1 = new LeaderboardEntry("Player1", 1000, new Date());
        LeaderboardEntry attempt2 = new LeaderboardEntry("Player2", 1500, new Date());
        LeaderboardEntry attempt3 = new LeaderboardEntry("Player3", 800, new Date());

        // Add the attempts to the leaderboard
        leaderboard.addEntry(attempt1);
        leaderboard.addEntry(attempt2);
        leaderboard.addEntry(attempt3);

        // Check if the leaderboard is in descending order based on scores
        assertEquals(attempt2, leaderboard.getLeaderboardData().get(0)); // Highest score
        assertEquals(attempt1, leaderboard.getLeaderboardData().get(1));
        assertEquals(attempt3, leaderboard.getLeaderboardData().get(2)); // Lowest score
    }
}
