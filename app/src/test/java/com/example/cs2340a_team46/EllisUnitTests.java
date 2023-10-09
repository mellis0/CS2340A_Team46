package com.example.cs2340a_team46;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.cs2340a_team46.views.ConfigActivity;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class EllisUnitTests {
    @Test
    public void validateInput_isCorrect() {
        String[] validNames = {"  jo nah", "  _   ", "robert"};
        int[] validDifficulties = {1, 2, 3};
        int[] validCharacters = {1, 2, 3};

        String[] invalidNames = {"    ", "         ", ""};
        int[] invalidDifficulties = {0, 4, -3, 90};
        int[] invalidCharacters = {0, 4, -3, 90};


        assertEquals(null, ConfigActivity.validateInput(
                validNames[0],
                validDifficulties[0],
                validCharacters[0]
        ));

        assertEquals(null, ConfigActivity.validateInput(
                validNames[1],
                validDifficulties[0],
                validCharacters[2]
        ));

        assertEquals(null, ConfigActivity.validateInput(
                validNames[2],
                validDifficulties[2],
                validCharacters[1]
        ));

        // failure expected

        assertEquals("Please enter a name", ConfigActivity.validateInput(
                invalidNames[0],
                validDifficulties[2],
                validCharacters[2]
        ));

        assertEquals("Please enter a name", ConfigActivity.validateInput(
                invalidNames[0],
                invalidDifficulties[2],
                invalidCharacters[3]
        ));

        assertEquals("Please select difficulty", ConfigActivity.validateInput(
                validNames[0],
                invalidDifficulties[0],
                validCharacters[2]
        ));

        assertEquals("Please select difficulty", ConfigActivity.validateInput(
                validNames[2],
                invalidDifficulties[2],
                invalidCharacters[3]
        ));

        assertEquals("Please select a character", ConfigActivity.validateInput(
                validNames[0],
                validDifficulties[0],
                invalidCharacters[0]
        ));

        assertEquals("Please select a character", ConfigActivity.validateInput(
                validNames[2],
                validDifficulties[1],
                invalidCharacters[3]
        ));
    }
}