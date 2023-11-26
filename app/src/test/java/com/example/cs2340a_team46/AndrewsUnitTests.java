package com.example.cs2340a_team46;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.lifecycle.LiveData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.example.cs2340a_team46.models.Arrow;
import com.example.cs2340a_team46.models.Enemies.BasicEnemy;
import com.example.cs2340a_team46.models.Enemies.BigEnemy;
import com.example.cs2340a_team46.models.Enemies.Enemy;
import com.example.cs2340a_team46.models.Enemies.FastEnemy;
import com.example.cs2340a_team46.models.Enemies.SmallEnemy;
import com.example.cs2340a_team46.models.Joystick;
import com.example.cs2340a_team46.models.Location;
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
//    @Test
//    public void check_setInnerJoystick_withoutChangeInInnerVars() {
//        float a = 278F;
//        float b = 1204F;
//        Joystick joy = new Joystick();
//        joy.setInner(a,b);
//        String a1 = Float.toString(a);
//        String a2 = Float.toString(joy.getInnerX());
//        assertEquals(a1, a2);
//        String b1 = Float.toString(b);
//        String b2 = Float.toString(joy.getInnerY());
//        assertEquals(b1, b2);
//        double c = 5.0;
//        String c1 = Double.toString(c);
//        String c2 = Double.toString(joy.getDistance());
//        assertEquals(c1, c2);
//    }


    // checks if correct value is returned for isPressed method
//    @Test
//    public void checkCorrect_isPressed()  {
//        float a = 278F;
//        float b = 1204F;
//        Joystick joys = new Joystick();
//        joys.setInner(a,b);
//        assertEquals(true, joys.getPressed());
//    }




    // sprint 4 test cases

    @Test
    public void check_LocationSetForPlayer() {
        Player agent = new Player();
        double ax = 1.2;
        double yx = 2.5;
        agent.setLocation(ax, yx);
        Location loc = agent.getLocation();
        assertEquals(ax, loc.getX(), 0);
        assertEquals(yx, loc.getY(), 0);
    }

    @Test
    public void check_Round() throws Exception {
        Location location = new Location();
        double cord = 2.5;
        double defined = 4.0;
        Method m = location.getClass().getDeclaredMethod("round");
        m.setAccessible(true);
        Object result = m.invoke(location);
        assertEquals(2.5, result);
    }



    // sprint 5 test cases

    @Test
    public void testArrowLocation() {
        Location loc = new Location(10,10);
        Arrow a = new Arrow(loc,3.14f, 100, 100);
        a.updateLocation();
        float deg = (float) Math.toDegrees(3.14);
        deg += 180;
        deg = (deg + 90) % 360;
        deg -= 180;
        float head = (float) Math.toRadians(deg);
        float actualX = (float) (20 * Math.sin(head));
        float actualY = (float) (20 * -1 * Math.cos(head));
        assertEquals(actualX, a.getX(), 0);
        assertEquals(actualY, a.getY(), 0);
    }
    @Test
    public void testArrowCollision_BasicEnemy() {
        Location loc = new Location(20,20);
        Arrow ab = new Arrow(loc,3.14f, 50, 30);
        Player agent = new Player();
        BasicEnemy enemy = new BasicEnemy(agent);
        boolean check = enemy.checkArrowCollision(ab.getLocation());
        assertEquals(true, check);
    }

    @Test
    public void testArrowCollision_BigEnemy() {
        Location loc = new Location(30,30);
        Arrow ab = new Arrow(loc,3.14f, 50, 80);
        Player agent = new Player();
        BigEnemy enemy = new BigEnemy(agent);
        boolean check = enemy.checkArrowCollision(ab.getLocation());
        assertEquals(true, check);
    }

    @Test
    public void testArrowCollision_FastEnemy() {
        Location loc = new Location(40,40);
        Arrow ab = new Arrow(loc,3.14f, 70, 50);
        Player agent = new Player();
        FastEnemy enemy = new FastEnemy(agent);
        boolean check = enemy.checkArrowCollision(ab.getLocation());
        assertEquals(true, check);
    }

    @Test
    public void testArrowCollision_SmallEnemy() {
        Location loc = new Location(50,50);
        Arrow ab = new Arrow(loc,3.14f, 60, 50);
        Player agent = new Player();
        SmallEnemy enemy = new SmallEnemy(agent);
        boolean check = enemy.checkArrowCollision(ab.getLocation());
        assertEquals(true, check);
    }
}

