package com.example.cs2340a_team46;

import static org.junit.Assert.assertEquals;

import com.example.cs2340a_team46.models.Player;
import com.example.cs2340a_team46.viewmodels.GameViewModel;

import org.junit.Test;

public class OtsukaUnitTests {
    @Test
    public void easyDifficultyToHealth() {
        //Take the difficulties and see if the health values are accurate
        int difficulty = 1;
        Player test = Player.getInstance();
        //Test Easy Difficulty
        GameViewModel.setPlayerHealth(difficulty);
        assertEquals(150, test.getPlayerHealth());
    }
    @Test
    public void normalDifficultyToHealth() {
        int difficulty = 2;
        Player test = Player.getInstance();
        //Test Normal Difficulty
        GameViewModel.setPlayerHealth(difficulty);
        assertEquals(100, test.getPlayerHealth());
    }


}
