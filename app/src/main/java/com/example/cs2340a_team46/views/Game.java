package com.example.cs2340a_team46.views;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.graphics.Paint;
import android.view.MotionEvent;
import com.example.cs2340a_team46.models.Tilemap;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import java.util.Random;
import java.util.Timer;

import android.os.Handler;
import android.view.View;

import com.example.cs2340a_team46.models.Joystick;
import com.example.cs2340a_team46.models.Player;
import com.example.cs2340a_team46.models.Tilemap1;
import com.example.cs2340a_team46.models.Tilemap2;
import com.example.cs2340a_team46.models.Tilemap3;
import com.example.cs2340a_team46.viewmodels.GameViewModel;


public class Game extends View implements Observer {
    private Paint redPaint = new Paint();
    private SurfaceHolder holder;
    //    private float x, y;
    private Random rand = new Random();
    private Timer timer = new Timer();
    private Handler handler = new Handler();
    private Joystick joystick;
    private Player player;
    private Tilemap1 tilemap1;
    private Tilemap2 tilemap2;
    private Tilemap3 tilemap3;
    private int level;
    float x;
    float y;
    private Activity parentActivity;
    boolean gameEnds;

    public Game(Context context, Activity activity) {
        super(context);
        this.parentActivity = activity;
        joystick = Joystick.getInstance();
        player = Player.getInstance();
        player.addObserver(this);
        tilemap1 = new Tilemap1(context);
        tilemap2 = new Tilemap2(context);
        tilemap3 = new Tilemap3(context);
        level = 1;
        gameEnds = false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (gameEnds) {
            return;
        }
        super.onDraw(canvas);
        //updateJoystick
        if (level == 1) {
            tilemap1.drawTilemap(canvas);
        } else if (level == 2) {
            tilemap2.drawTilemap(canvas);
        } else {
            tilemap3.drawTilemap(canvas);
        }
        joystick.drawJoystick(canvas);
        Bitmap characterSprite = BitmapFactory.decodeResource(getContext().getResources(), GameViewModel.getCharacter());


        //
        //
        // display player info
        //
        Paint tP = new Paint();
        tP.setColor(Color.WHITE);
        tP.setTextSize(50);
        String name = GameViewModel.getPlayerName();
        int h = GameViewModel.getPlayerHealth();
        String health = Integer.toString(h);
        String difficulty = GameViewModel.getDifficultyString();
        LiveData<Integer> sc = GameViewModel.getPlayerScore();
        String score = Integer.toString(sc.getValue());
        canvas.drawText("NAME: ", 50, 50, tP);
        canvas.drawText(name, 100, 150, tP);
        canvas.drawText("HEALTH: ", 50, 250, tP);
        canvas.drawText(health, 100, 350, tP);
        canvas.drawText("DIFFICULTY: ", 50, 450, tP);
        canvas.drawText(difficulty, 100, 550, tP);
        canvas.drawText("SCORE: ", 50, 650, tP);
        canvas.drawText(score, 100, 750, tP);
        //
        //
        //


        // Draw the image on the canvas at a specific position

        player.updateLoc(joystick.getInnerLoc(), true);

        if (level == 1 && tilemap1.getIfFlask(player.getLocation()) ||
                level == 2 && tilemap2.getIfFlask(player.getLocation()) ||
                level == 3 && tilemap3.getIfFlask(player.getLocation())) {
            if (level < 3) {
                level += 1;
                player.setX(500);
                player.setY(500);
            } else {
                player.setX(500);
                player.setY(500);
                gameEnds = true;
                Intent intent = new Intent(parentActivity, EndActivity.class);
                parentActivity.startActivity(intent);
                parentActivity.finish();
            }

        }
//        canvas.drawText(String.valueOf(level), 50, 850, tP);
//        canvas.drawText(String.valueOf(player.getCharX()), 50, 850, tP);
//        canvas.drawText(String.valueOf(player.getCharY()), 50, 1050, tP);
        postInvalidate();

        // these two lines are now handled in update(), which follows the observer pattern.
//        x = (float)(player.getCharX());
//        y = (float)(player.getCharY());


        //72 is offset since image draws 72 pixels too high
        //56 to right gets to middle
        // 90 down to get to center
        canvas.drawBitmap(characterSprite, x - 56, y - 162, null);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_POINTER_DOWN) {
            if (joystick.isPressed()) {
                joystick.setInner(event.getX(), event.getY());
                joystick.updateDistance();
//                player.updateLoc(joystick.getInnerX(), joystick.getInnerY(), joystick.getDistance());
                postInvalidate();
            }
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            if (joystick.getPressed()) {
                joystick.setInner(event.getX(), event.getY());
                joystick.updateDistance();
//                player.updateLoc(joystick.getInnerX(), joystick.getInnerY(), joystick.getDistance());
                postInvalidate();
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_POINTER_UP) {
            if (joystick.getPressed()) {
                joystick.setPressed(false);
                joystick.setInner(Joystick.OUTER_X, Joystick.OUTER_Y);
                joystick.updateDistance();
                postInvalidate();
            }
        }

        return true;
    }


    @Override
    public void update(Observable observable, Object o) {
        x = (float) player.getX();
        y = (float) player.getY();
    }
}

