package com.example.cs2340a_team46;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

import com.example.cs2340a_team46.models.Leaderboard;
import com.example.cs2340a_team46.models.LeaderboardEntry;

public class HsiehUnitTests {
    private Leaderboard leaderboard;

    @Before
    public void setUp() {
        leaderboard = Leaderboard.getInstance();
    }

    @Test
    public void testAddEntry() {
        // tests if we are able to add entries properly
        leaderboard.addEntry("Player1", 100);

        List<LeaderboardEntry> entries = leaderboard.getEntries();


        assertEquals(1, entries.size()); // Expecting one entry
        assertEquals("Player1", entries.get(0).getPlayerName());
        assertEquals(100, entries.get(0).getScore());
    }

    @Test
    public void testLeaderboardOrder() {
        // makes sure the leaderboard is in the correct order
        leaderboard.addEntry("Player1", 200);
        leaderboard.addEntry("Player2", 150);
        leaderboard.addEntry("Player3", 250);


        List<LeaderboardEntry> entries = leaderboard.getEntries();


        assertEquals(3, entries.size()); // Expecting three entries
        assertEquals("Player3", entries.get(0).getPlayerName()); // Highest score
        assertEquals("Player1", entries.get(1).getPlayerName());
        assertEquals("Player2", entries.get(2).getPlayerName()); // Lowest score
    }
}

