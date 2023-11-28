package com.example.cs2340a_team46.views;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.models.Agent;
import com.example.cs2340a_team46.models.Arrow;
import com.example.cs2340a_team46.models.Enemies.Enemy;
import com.example.cs2340a_team46.models.Location;
import com.example.cs2340a_team46.models.Powerup.Powerup;
import com.example.cs2340a_team46.models.Powerup.PowerupAssigner;
import com.example.cs2340a_team46.models.Tilemap;

import androidx.lifecycle.LiveData;

import java.util.Observable;
import java.util.Observer;

import android.view.View;

import com.example.cs2340a_team46.models.Tilemap1;
import com.example.cs2340a_team46.models.Tilemap2;
import com.example.cs2340a_team46.models.Tilemap3;
import com.example.cs2340a_team46.viewmodels.GameViewModel;


public class Game extends View implements Observer {
    private Tilemap[] tileMaps;
    private float playerX;
    private float playerY;
    private Activity parentActivity;
    private boolean gameEnds;
    private boolean spaceKeyDown = false;

    public Game(Context context, Activity activity) {
        super(context);
        this.parentActivity = activity;
        GameViewModel.observePlayer(this);
        tileMaps = new Tilemap[]
            {new Tilemap1(context), new Tilemap2(context), new Tilemap3(context)};
        gameEnds = false;
    }

    private static Bitmap getBitmapFromSprite(Resources resources, int sprite) {
        return BitmapFactory.decodeResource(resources, sprite);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (gameEnds) {
            return;
        }

        //requestFocus();
        setFocusable(true); // can't capture keyboard input without this
        super.onDraw(canvas);
        //updateJoystick
        tileMaps[GameViewModel.getLevel()].drawTilemap(canvas);
        GameViewModel.drawJoystick(canvas);

        // display player info
        Paint tP = new Paint();
        tP.setColor(Color.WHITE);
        tP.setTextSize(50);
        String name = GameViewModel.getPlayerName();
        double h = GameViewModel.getPlayerHealth();
        String health = Integer.toString((int) h);
        String difficulty = GameViewModel.getDifficultyString();
        LiveData<Integer> sc = GameViewModel.getPlayerScore();
        String score = Integer.toString(sc.getValue());
        String powerups = PowerupAssigner.PowerupText();
        postInvalidate();
        canvas.drawText("NAME: ", 50, 50, tP);
        canvas.drawText(name, 100, 150, tP);
        canvas.drawText("HEALTH: ", 50, 250, tP);
        canvas.drawText(health, 100, 350, tP);
        canvas.drawText("DIFFICULTY: ", 50, 450, tP);
        canvas.drawText(difficulty, 100, 550, tP);
        canvas.drawText("SCORE: ", 50, 650, tP);
        canvas.drawText(score, 100, 750, tP);
        canvas.drawText("POWERUPS: ", 50, 850, tP);
        canvas.drawText(powerups, 100, 950, tP);



        // Draw the image on the canvas at a specific position


        // this method increments the level if an end condition (ie the flask) is reached
        // It returns true iff the player has just completed the end condition for the final level
        boolean finishedFinalLevel = GameViewModel
                .nextLevelIfEndConditionSatisfied(tileMaps[GameViewModel.getLevel()]);

        if (finishedFinalLevel) {
            gameEnds = true;
            Intent intent = new Intent(parentActivity, EndActivity.class);
            parentActivity.startActivity(intent);
            parentActivity.finish();

        }

        // GameViewModel.powerupPickup(tileMaps[GameViewModel.getLevel()]);
        postInvalidate();

        Enemy[] enemies = GameViewModel.getCurrLevelEnemies();

        GameViewModel.updateEnemyLocations(tileMaps[GameViewModel.getLevel()]);

        for (Enemy enemy : enemies) {
            Bitmap b = getBitmapFromSprite(getContext().getResources(), enemy.getSprite());
            canvas.drawBitmap(b, (float) (enemy.getX() - b.getScaledWidth(canvas) / 2.0),
                    (float) (enemy.getY() - b.getScaledHeight(canvas) / 2.0), null);
        }

        GameViewModel.updateArrowLocations();

        Arrow[] arrows = GameViewModel.getArrows();

        for (Arrow arrow : arrows) {
            canvas.drawBitmap(arrow.getBitmap(), arrow.getX(), arrow.getY(), null);
        }




        Bitmap playerSprite = getBitmapFromSprite(getContext().getResources(),
                GameViewModel.getPlayerSprite());

        Bitmap bowSprite = getBitmapFromSprite(getContext().getResources(), R.drawable.bow);
        //72 is offset since image draws 72 pixels too high
        //56 to right gets to middle
        // 90 down to get to center

        // @Ryan, these values don't line up with the ones you had, but they're close
        // we need a way to programmatically find these values cus we're gonna have sprites with
        // different sizes.
        // see the code above for drawing enemies, too.

        float drawX = playerX - (float) (playerSprite.getScaledWidth(canvas) / 2.0);
        float drawY = playerY - (float) (playerSprite.getScaledHeight(canvas) / 2.0);
        canvas.drawBitmap(playerSprite, drawX, drawY, null);
        canvas.drawBitmap(bowSprite, drawX + 90, drawY + 100, null);

        Powerup[] powerupDisplays = GameViewModel.getPowerups();
        for (Powerup powerupDisplay : powerupDisplays) {
            Bitmap b = getBitmapFromSprite(getContext().getResources(), powerupDisplay.getDrawable());
            canvas.drawBitmap(b, powerupDisplay.getX(), powerupDisplay.getY(), null);
        }
        GameViewModel.updatePlayerLocation(tileMaps[GameViewModel.getLevel()]);
        postInvalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (GameViewModel.handleUserInput(event)) {
            postInvalidate();
        }
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_SPACE && !spaceKeyDown) {
            spaceKeyDown = true;
            GameViewModel.playerAttack(getResources());
        }
        return true;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_SPACE) {
            spaceKeyDown = false;
        }
        return true;
    }


    // this function literally doesn't make sense in our current framework,
    // but we need to implement it in the Observer pattern...
    @Override
    public void update(Observable observable, Object o) {
        // Location playerLoc = GameViewModel.getPlayerLocation();
        Location playerLoc = ((Agent) observable).getLocation();
        playerX = (float) playerLoc.getX();
        playerY = (float) playerLoc.getY();
    }
}

