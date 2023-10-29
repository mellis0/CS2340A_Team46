package com.example.cs2340a_team46.viewmodels;

import android.graphics.Canvas;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.models.BasicEnemyFactory;
import com.example.cs2340a_team46.models.Enemy;
import com.example.cs2340a_team46.models.EnemyFactory;
import com.example.cs2340a_team46.models.Joystick;
import com.example.cs2340a_team46.models.Location;
import com.example.cs2340a_team46.models.ScoreModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.example.cs2340a_team46.models.Player;
import com.example.cs2340a_team46.models.Tilemap;
import com.example.cs2340a_team46.views.Game;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class GameViewModel extends ViewModel {

    private static final int MAX_LEVEL = 2; // levels 0, 1, & 2 exist

    private static ScoreModel scoreModel = new ScoreModel();
    private static LiveData<Integer> score = scoreModel.getScore();
    private static final int COUNTDOWN_DURATION = 100000;
    private static final int COUNTDOWN_INTERVAL = 1000;
    private static int level = 0;
    private static ArrayList<Enemy> currLevelEnemies;
    private static final BasicEnemyFactory BASIC_ENEMY_FACTORY = new BasicEnemyFactory();

    // length of this array should equal MAX_LEVEL + 1
    private static final Map<EnemyFactory, Integer>[] ENEMY_COUNTS = new HashMap[] {
            new HashMap<EnemyFactory, Integer>(){{
                put(BASIC_ENEMY_FACTORY, 1);
            }},
            new HashMap<EnemyFactory, Integer>(){{
                put(BASIC_ENEMY_FACTORY, 1);
            }},
            new HashMap<EnemyFactory, Integer>(){{
                put(BASIC_ENEMY_FACTORY, 1);
            }}
    };
    private static CountDownTimer countDownTimer = new
            CountDownTimer(COUNTDOWN_DURATION, COUNTDOWN_INTERVAL) {
        @Override
        public void onTick(long millisUntilFinished) {
            GameViewModel.scoreModel.setScore(score.getValue() - 1);
        }
        @Override
        public void onFinish() {

        }
    };

    public static boolean handleUserInput(MotionEvent event) {
        boolean postInvalidate = false;
        int action = event.getAction();
        if (joystick.isPressed() && (action == MotionEvent.ACTION_DOWN
                || action == MotionEvent.ACTION_POINTER_DOWN)) {
            joystick.setInner(event.getX(), event.getY());
            joystick.updateDistance();
            postInvalidate = true;
        } else if (joystick.getPressed()) {
            if (action == MotionEvent.ACTION_MOVE) {
                joystick.setInner(event.getX(), event.getY());
                joystick.updateDistance();
                postInvalidate = true;
            } else if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_POINTER_UP) {
                joystick.setPressed(false);
                joystick.setInner(Joystick.OUTER_X, Joystick.OUTER_Y);
                joystick.updateDistance();
                postInvalidate = true;
            }
        }

        return postInvalidate;
    }

    private static void initializeCurrLevelEnemies() {
        currLevelEnemies = new ArrayList<Enemy>();
        for (Map.Entry<EnemyFactory, Integer> entry : ENEMY_COUNTS[level].entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                currLevelEnemies.add(entry.getKey().generateEnemy());
            }
        }
        // initialize enemy location to be not on top of the player
        for (Enemy enemy : currLevelEnemies) {
            enemy.setLocation(1000, 500);
        }
    }

    public static Enemy[] getCurrLevelEnemies() {
        if (currLevelEnemies == null) {
            initializeCurrLevelEnemies();
        }
        Enemy[] out = new Enemy[currLevelEnemies.size()];
        out = currLevelEnemies.toArray(out);
        return out;
    }

    public static int getLevel() {
        return level;
    }
    public static void incrementLevel() {
        level = Math.min(level + 1, MAX_LEVEL);
        initializeCurrLevelEnemies();
    }

    public static boolean nextLevelIfEndConditionSatisfied(Tilemap tm) {
        boolean out = false;
        if (tm.getIfFlask(player.getLocation())) {
            if (level >= MAX_LEVEL) {
                out = true;
            }
            incrementLevel(); // this won't increment past MAX_LEVEL
            player.setX(500);
            player.setY(500);
        }
        return out;
    }

    private static Joystick joystick = Joystick.getInstance();
    public static void drawJoystick(Canvas canvas) {
        joystick.drawJoystick(canvas);
    }

    private static Player player = Player.getInstance();
    public static void observePlayer(Game game) {
        player.addObserver(game);
    }

    public static Location getPlayerLocation() {
        return player.getLocation();
    }


    public static void updatePlayerLocation(Tilemap tm) {
        player.updateLoc(tm, joystick.getInnerLoc(), true);
    }

    public static void updateEnemyLocations(Tilemap tm) {
        for (Enemy enemy : currLevelEnemies) {
            // @Ryan, I would reccomend moving updateLoc from the Agent class and putting it
            // in Enemy and Player. This way, the method signature can differ between enemies and
            // players, because enemies might need different info to move than the player.

            // up to you tho, there's probably a way to implement it with the
            // current method signature
            enemy.updateLoc(tm, joystick.getInnerLoc(), true);
        }
    }
    public static void setPlayerHealth(int difficultyVal) {
        if (difficultyVal == 1) {
            player.setHealth(150);
            // GameViewModel.playerHealth = 150;
        } else if (difficultyVal == 2) {
            player.setHealth(100);
            // GameViewModel.playerHealth = 100;
        } else if (difficultyVal == 3) {
            player.setHealth(50);
            // GameViewModel.playerHealth = 50;
        } else {
            throw new IllegalArgumentException("Difficulty must be 1, 2, or 3");
        }
    }

    public static void setDifficulty(int difficultyVal) {
        if (difficultyVal == 1) {
            player.setDifficulty(1);
            // GameViewModel.difficulty = "Easy";
        } else if (difficultyVal == 2) {
            player.setDifficulty(2);
            // GameViewModel.difficulty = "Normal";
        } else if (difficultyVal == 3) {
            player.setDifficulty(3);
            // GameViewModel.difficulty = "Hard";
        } else {
            throw new IllegalArgumentException("Difficulty must be 1, 2, or 3");
        }
    }

    public static void setPlayerName(String name) {
        player.setPlayerName(name);
        // GameViewModel.playerName = name;
    }

    public static void setPlayerSprite(int characterRadioButton) {
        if (characterRadioButton == 1) {
            player.setSprite(R.drawable.angel);
        } else if (characterRadioButton == 2) {
            player.setSprite(R.drawable.knight);
        } else if (characterRadioButton == 3) {
            player.setSprite(R.drawable.lizard);
        } else {
            throw new IllegalArgumentException("characterRadioButton must be 1, 2, or 3");
        }
    }

    public static int getPlayerHealth() {
        return player.getHealth();
    }

    public static int getDifficulty() {
        return player.getDifficulty();
    }

    public static String getDifficultyString() {
        return player.getDifficultyString();
    }

    public static String getPlayerName() {
        return player.getPlayerName();
    }

    public static int getPlayerSprite() {
        return player.getSprite();
    }
    public static LiveData<Integer> getPlayerScore() {
        return score;
    }

    public static void startScoreCountdown() {
        GameViewModel.scoreModel.setScore(100);
        countDownTimer.start();
    }
    public static void endScoreCountdown() {
        countDownTimer.cancel();
    }
}
