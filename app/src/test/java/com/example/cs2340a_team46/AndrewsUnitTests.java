package com.example.cs2340a_team46;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.cs2340a_team46.models.Player;
import com.example.cs2340a_team46.viewmodels.GameViewModel;
import com.example.cs2340a_team46.views.ConfigActivity;

public class AndrewsUnitTests {
    @Test
    public void validCharacter_isCorrect() {
        // testing to see if the characters are valid or not
        int[] validCharacters = {1, 2, 3};
        int[] invalidCharacters = {0, 4, -3, 90};

        for (int validCharacter : validCharacters) {
            assertEquals(true, ConfigActivity.validCharacter(validCharacter));
        }

        for (int invalidCharacter : invalidCharacters) {
            assertEquals(false, ConfigActivity.validCharacter(invalidCharacter));
        }
    }
    @Test
    public void setDifficulty_isCorrect() {
        //tests the difficulties to see if they establish the correct level of easy, normal, hard
        int first = 1;
        int sec = 2;
        int third = 3;

        Player player = Player.getInstance();

        GameViewModel.setDifficulty(first);
        assertEquals("Easy", player.getDifficulty());
        GameViewModel.setDifficulty(sec);
        assertEquals("Normal", player.getDifficulty());
        GameViewModel.setDifficulty(third);
        assertEquals("Hard", player.getDifficulty());
    }
}
