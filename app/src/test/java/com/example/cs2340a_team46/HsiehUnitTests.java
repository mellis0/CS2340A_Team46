package com.example.cs2340a_team46;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.cs2340a_team46.models.Leaderboard;
import com.example.cs2340a_team46.models.LeaderboardEntry;
import com.example.cs2340a_team46.viewmodels.LeaderboardViewModel;
import com.example.cs2340a_team46.models.ScoreModel;

public class HsiehUnitTests {
    private Leaderboard leaderboard;
    private ScoreModel scoremodel;

    @Before
    public void setUp() {
        leaderboard = Leaderboard.getInstance();
        scoremodel = new ScoreModel();
    }

    @Test
    public void testAddAttemptToLeaderboard() {
        // Create a sample attempt
        LeaderboardEntry attempt = new LeaderboardEntry("Player1", 10, new Date());

        // Add the attempt to the leaderboard
        LeaderboardViewModel.addEntry(attempt);

        // Check if the leaderboard contains the added attempt
        assertTrue(leaderboard.getLeaderboardData().contains(attempt));
    }

    @Test
    public void testLeaderboardOrder() {
        // Create/add multiple attempts with different scores
        LeaderboardEntry attempt1 = new LeaderboardEntry("Player1", 80, new Date());
        LeaderboardViewModel.addEntry(attempt1);
        LeaderboardEntry attempt2 = new LeaderboardEntry("Player2", 100, new Date());
        LeaderboardViewModel.addEntry(attempt2);
        LeaderboardEntry attempt3 = new LeaderboardEntry("Player3", 50, new Date());
        LeaderboardViewModel.addEntry(attempt3);


        // Check if the leaderboard is in descending order based on scores
        assertEquals(attempt2, leaderboard.getLeaderboardData().get(0)); // Highest score
        assertEquals(attempt1, leaderboard.getLeaderboardData().get(1));
        assertEquals(attempt3, leaderboard.getLeaderboardData().get(2)); // Lowest score
    }
}
