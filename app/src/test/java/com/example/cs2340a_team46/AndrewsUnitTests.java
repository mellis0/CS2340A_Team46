package com.example.cs2340a_team46;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.lifecycle.LiveData;

import org.junit.Test;

import com.example.cs2340a_team46.models.Agent;
import com.example.cs2340a_team46.models.Joystick;
import com.example.cs2340a_team46.models.Player;
import com.example.cs2340a_team46.viewmodels.GameViewModel;
import com.example.cs2340a_team46.views.ConfigActivity;
import com.example.cs2340a_team46.views.Game;

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


    // sprint 3 unit tests

    // checks setInner method and update distance method
    // checks innerX and innerY vars when there is no change, condition is not met to change
    @Test
    public void check_setInnerJoystick_withoutChangeInInnerVars() {
        float a = 278F;
        float b = 1204F;
        Joystick joy = new Joystick();
        joy.setInner(a,b);
        String a1 = Float.toString(a);
        String a2 = Float.toString(joy.getInnerX());
        assertEquals(a1, a2);
        String b1 = Float.toString(b);
        String b2 = Float.toString(joy.getInnerY());
        assertEquals(b1, b2);
        double c = 5.0;
        String c1 = Double.toString(c);
        String c2 = Double.toString(joy.getDistance());
        assertEquals(c1, c2);
    }

    // checks if correct value is returned for isPressed method
    @Test
    public void checkCorrect_isPressed()  {
        float a = 278F;
        float b = 1204F;
        Joystick joys = new Joystick();
        joys.setInner(a,b);
        assertEquals(true, joys.getPressed());
    }

    // sprint 4 test cases

    // checks if player can access location method in agent and correctly set it
    public void check_setLocation() {
        Player agent = new Player();
        double ax = 1.2;
        double yx = 2.5;
        agent.setLocation(ax, yx);
        double x = agent.getX();
        double y = agent.getY();
        assertEquals(ax, x, 0);
        assertEquals(yx, y, 0);
    }


}
