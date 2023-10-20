package com.example.cs2340a_team46.views;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.graphics.Paint;
import android.view.MotionEvent;
import com.example.cs2340a_team46.models.Tilemap;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.Random;
import java.util.Timer;

import android.os.Handler;
import android.view.View;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.models.Joystick;
import com.example.cs2340a_team46.models.Player;
import com.example.cs2340a_team46.viewmodels.GameViewModel;


public class Game extends View {
    private Paint redPaint = new Paint();
    private SurfaceHolder holder;
    //    private float x, y;
    private Random rand = new Random();
    private Timer timer = new Timer();
    private Handler handler = new Handler();
    private Joystick joystick;
    private Player player;
    private Tilemap tilemap;
    float x;
    float y;

    public Game(Context context) {
        super(context);
        joystick = new Joystick();
        player = Player.getInstance();
        tilemap = new Tilemap(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //updateJoystick
        tilemap.drawTilemap(canvas);
        joystick.drawJoystick(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.lizard);


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
        int d = GameViewModel.getDifficulty();
        String difficulty = Integer.toString(d);
        LiveData<Integer> sc = GameViewModel.getPlayerScore();
        String score = Integer.toString(sc.getValue());
        canvas.drawText(name, 40, 50, tP);
        canvas.drawText(health, 40, 80, tP);
        canvas.drawText(difficulty, 40, 110, tP);
        canvas.drawText(score, 40, 140, tP);
        //
        //
        //


        // Draw the image on the canvas at a specific position

        player.updateLoc(joystick.getInnerX(), joystick.getInnerY(), joystick.getDistance());
        postInvalidate();
        x = (float)(player.getCharX());
        y = (float)(player.getCharY());
        //72 is offset since image draws 72 pixels too high
        //56 to right gets to middle
        // 90 down to get to center
        canvas.drawBitmap(bitmap, x-56, y-162, null);

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
                joystick.setInner(275, 1200);
                joystick.updateDistance();
                postInvalidate();
            }
        }

        return true;
    }


//    @Override
//    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
//        this.surfaceCreated(surfaceHolder);
////        timer.schedule(new TimerTask() {
////            @Override
////            public void run() {
////                handler.post(new Runnable() {
////                    @Override
////                    public void run() {
//////                        update();
//////                        render();
////                    }
////                });
////            }
////        }, 0, 100);
//
//    }
//
//    @Override
//    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
//
//    }
//
//    @Override
//    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
//
//    }


}

