package com.example.cs2340a_team46;

import com.example.cs2340a_team46.models.ScoreModel;
import com.example.cs2340a_team46.viewmodels.GameViewModel;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HsuUnitTest {

    private ScoreModel scoreModel;
    private GameViewModel gameViewModel;

    @Before
    public void setUp() {
        scoreModel = new ScoreModel();
        gameViewModel = new GameViewModel();
    }

    @Test
    public void testScoreNeverGoesBelowZero() {
        scoreModel.setScore(100);
        int updatedScore = scoreModel.getScore().getValue();
        assertEquals(100, updatedScore);
        scoreModel.setScore(50);
        updatedScore = scoreModel.getScore().getValue();
        assertEquals(50, updatedScore);
        scoreModel.setScore(-1);
        updatedScore = scoreModel.getScore().getValue();
        assertEquals(50, updatedScore);
    }

    @Test
    public void testSetAndGetPlayerHealth() {
        gameViewModel.setPlayerHealth(1);

        int playerHealth = gameViewModel.getPlayerHealth();
        assertEquals(150, playerHealth);

        gameViewModel.setPlayerHealth(2);

        playerHealth = gameViewModel.getPlayerHealth();
        assertEquals(100, playerHealth);

        gameViewModel.setPlayerHealth(3);

        playerHealth = gameViewModel.getPlayerHealth();
        assertEquals(50, playerHealth);
    }
}