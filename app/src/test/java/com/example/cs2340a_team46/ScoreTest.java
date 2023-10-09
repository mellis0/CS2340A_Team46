package com.example.cs2340a_team46;

import com.example.cs2340a_team46.models.ScoreModel;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ScoreTest {

    private ScoreModel scoreModel;

    @Before
    public void setUp() {
        scoreModel = new ScoreModel();
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
}