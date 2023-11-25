package com.example.cs2340a_team46;

import com.example.cs2340a_team46.models.Enemies.BasicEnemy;
import com.example.cs2340a_team46.models.Enemies.BigEnemy;
import com.example.cs2340a_team46.models.Enemies.Enemy;
import com.example.cs2340a_team46.models.Enemies.FastEnemy;
import com.example.cs2340a_team46.models.Enemies.SmallEnemy;
import com.example.cs2340a_team46.models.Player;
import com.example.cs2340a_team46.models.ScoreModel;
import com.example.cs2340a_team46.viewmodels.GameViewModel;
import com.example.cs2340a_team46.views.ConfigActivity;

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

//    @Test
//    public void testSetAndGetPlayerHealth() {
//        gameViewModel.setPlayerHealth(1);
//
//        int playerHealth = gameViewModel.getPlayerHealth();
//        assertEquals(150, playerHealth);
//
//        gameViewModel.setPlayerHealth(2);
//
//        playerHealth = gameViewModel.getPlayerHealth();
//        assertEquals(100, playerHealth);
//
//        gameViewModel.setPlayerHealth(3);
//
//        playerHealth = gameViewModel.getPlayerHealth();
//        assertEquals(50, playerHealth);
//    }

//    @Test
//    public void hardDifficultyToHealth() {
//        int difficulty = 3;
//        Player test = Player.getInstance();
//        //Test Normal Difficulty
//        GameViewModel.setPlayerHealth(difficulty);
//        assertEquals(50, test.getPlayerHealth());
//    }

    @Test
    public void nameIsCorrect() {
        Player player = Player.getInstance();
        GameViewModel.setPlayerName("Gio");
        assertEquals("Gio", player.getPlayerName());
    }
    @Test
    public void checkIsDamagingPlayer() {
        Player player = Player.getInstance();
        Enemy enemy = new BigEnemy(player);
        assertEquals(false, enemy.isDamagingPlayer);
    }
    @Test
    public void checkLastDamageTime() {
        Player player = Player.getInstance();
        Enemy enemy = new BigEnemy(player);
        assertEquals(0, enemy.lastDamageTime);
    }

    // Unit Tests for sprint 5
    @Test
    public void checkBigEnemyPoints() {
        Player player = Player.getInstance();
        Enemy enemy = new BigEnemy(player);
        assertEquals(100, enemy.getPointsWhenKilled());
    }

    @Test
    public void checkSmallEnemyPoints() {
        Player player = Player.getInstance();
        Enemy enemy = new SmallEnemy(player);
        assertEquals(80, enemy.getPointsWhenKilled());
    }

    @Test
    public void checkBasicEnemyPoints() {
        Player player = Player.getInstance();
        Enemy enemy = new BasicEnemy(player);
        assertEquals(30, enemy.getPointsWhenKilled());
    }

    @Test
    public void checkFastEnemyPoints() {
        Player player = Player.getInstance();
        Enemy enemy = new FastEnemy(player);
        assertEquals(50, enemy.getPointsWhenKilled());
    }
}