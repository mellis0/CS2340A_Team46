package com.example.cs2340a_team46;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.cs2340a_team46.views.ConfigActivity;


public class EllisUnitTests {

    @Test
    public void validName_isCorrect() {
        String[] validNames = {"  jo nah", "  _   ", "robert"};
        String[] invalidNames = {"    ", "         ", ""};

        for (String validName : validNames) {
            assertEquals(true, ConfigActivity.validName(validName));
        }

        for (String invalidName : invalidNames) {
            assertEquals(false, ConfigActivity.validName(invalidName));
        }
    }

    @Test
    public void validDifficulty_isCorrect() {
        int[] validDifficulties = {1, 2, 3};
        int[] invalidDifficulties = {0, 4, -3, 90};

        for (int validDifficulty : validDifficulties) {
            assertEquals(true, ConfigActivity.validDifficulty(validDifficulty));
        }

        for (int invalidDifficulty : invalidDifficulties) {
            assertEquals(false, ConfigActivity.validDifficulty(invalidDifficulty));
        }
    }
}