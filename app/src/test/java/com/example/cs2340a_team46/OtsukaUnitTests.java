package com.example.cs2340a_team46;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.util.Log;

import com.example.cs2340a_team46.models.Player;
import com.example.cs2340a_team46.models.Tilemap;
import com.example.cs2340a_team46.models.Joystick;
import com.example.cs2340a_team46.viewmodels.GameViewModel;
import com.example.cs2340a_team46.views.Game;

import org.junit.Test;

public class OtsukaUnitTests {
//    @Test
//    public void easyDifficultyToHealth() {
//        //Take the difficulties and see if the health values are accurate
//        int difficulty = 1;
//        Player test = Player.getInstance();
//        //Test Easy Difficulty
//        GameViewModel.setPlayerHealth(difficulty);
//        assertEquals(150, test.getPlayerHealth());
//    }
//    @Test
//    public void normalDifficultyToHealth() {
//        int difficulty = 2;
//        Player test = Player.getInstance();
//        //Test Normal Difficulty
//        GameViewModel.setPlayerHealth(difficulty);
//        assertEquals(100, test.getPlayerHealth());
//    }

    //Sprint 3
//    @Test
//    public void checkJoystickStaysInOuterCircle() {
//        Joystick joystick = new Joystick();
//
//        joystick.setInner(1000,1000);
//        joystick.updateDistance();
//        assertEquals((int)joystick.getOuterRadius(), (int)Math.round(joystick.getDistance()), 0);
//    }
//    @Test
//    public void checkSpeedChangesWithJoystickDistance() {
//        Joystick joystick2 = new Joystick();
//        joystick2.setInner(280,1200);
//        Player player = Player.getInstance();
//        double initX = player.getCharX();
//        double initY = player.getCharY();
//        player.updateLoc(joystick2.getInnerX(),joystick2.getInnerY(), false);
//        double lowestSpeed = player.getCharX() - initX;
//
//        player.setCharX(initX);
//        joystick2.setInner(290,1200);
//        player.updateLoc(joystick2.getInnerX(),joystick2.getInnerY(), false);
//        double middleSpeed = player.getCharX() - initX;
//
//        player.setCharX(initX);
//        joystick2.setInner(300,1200);
//        player.updateLoc(joystick2.getInnerX(),joystick2.getInnerY(), false);
//        double highSpeed = player.getCharX() - initX;
//        assertTrue(lowestSpeed < middleSpeed && middleSpeed < highSpeed);
//
//    }


}
