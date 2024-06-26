package com.example.cs2340a_team46;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.cs2340a_team46.models.Arrow;
import com.example.cs2340a_team46.models.Enemies.BasicEnemy;
import com.example.cs2340a_team46.models.Enemies.BasicEnemyFactory;
import com.example.cs2340a_team46.models.Location;
import com.example.cs2340a_team46.models.NormalMovement;
import com.example.cs2340a_team46.models.Player;
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

    // ~~~~~~~~~~~~~~~~~ Sprint 3 Tests ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//    @Test
//    public void NormalMovement_isCorrect() {
//        double charX = 20;
//        double charY = 20;
//        double joystick_x = 275;
//        double joystick_y = 1200;
//        // can't check collisions in the test b/c the game tilemap isn't instantiated
//        boolean collideCheck = false;
//
//        NormalMovement inst = new NormalMovement();
//        double[] result = inst.move(charX, charY, joystick_x, joystick_y, collideCheck);
//
//
//        int[] roundedResult = new int[2];
//        roundedResult[0] = (int) (result[0] * 1000);
//        roundedResult[1] = (int) (result[1] * 1000);
//
//        int[] expected = new int[] {(int) (charX * 1000), (int) (charY * 1000)};
//        assertArrayEquals(roundedResult, expected);
//    }


    @Test
    public void defaultMovementBehavior_isCorrect() {
        Player p = Player.getInstance();
        assertEquals(p.getMovementBehavior().getClass().getSimpleName(), NormalMovement.class.getSimpleName());
    }

    // ~~~~~~~~~~~~~~~~~ Sprint 4 Tests ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Test
    public void testBasicEnemyFactory() {
        BasicEnemyFactory fac = new BasicEnemyFactory();
        Player p = Player.getInstance();
        Object o = fac.generateEnemy(p);
        assertThat(o, instanceOf(BasicEnemy.class));
    }

    @Test
    public void testLocationEquality() {
        Location loc1 = new Location(3.0, 4.0);
        Location loc2 = new Location(3.002, 3.997);
        assertEquals(true, loc1.equals(loc2));
    }


    // ~~~~~~~~~~~~~~~~~~ Sprint 5 Tests ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Test
    public void testArrowinScreen() {
        Arrow a = new Arrow(new Location(20, 20), 3.14f, 100, 100);
        assertEquals(false, a.outOfScreen());
    }

    @Test
    public void testArrowOutOfScreen() {
        Arrow b = new Arrow(new Location(110, 20), 3.14f, 100, 100);
        assertEquals(true, b.outOfScreen());
    }
}