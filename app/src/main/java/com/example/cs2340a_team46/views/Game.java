package com.example.cs2340a_team46.views;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.graphics.Paint;
import android.view.MotionEvent;

import androidx.annotation.NonNull;

import java.util.Random;
import java.util.Timer;

import android.os.Handler;
import android.view.View;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.models.Joystick;
import com.example.cs2340a_team46.models.Player;


public class Game extends View implements SurfaceHolder.Callback {
    private Paint redPaint = new Paint();
    private SurfaceHolder holder;
    //    private float x, y;
    private Random rand = new Random();
    private Timer timer = new Timer();
    private Handler handler = new Handler();
    private Joystick joystick;
    private Player player;
    float x;
    float y;

    public Game(Context context) {
        super(context);
        joystick = new Joystick();
        player = Player.getInstance();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //updateJoystick
        joystick.drawJoystick(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.lizard);

        // Draw the image on the canvas at a specific position
        player.updateLoc(joystick.getInnerX(), joystick.getInnerY(), joystick.getDistance());
        x = (float)(player.getCharX());
        y = (float)(player.getCharY());
        canvas.drawBitmap(bitmap, x, y, null);

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


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        this.surfaceCreated(surfaceHolder);
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
////                        update();
////                        render();
//                    }
//                });
//            }
//        }, 0, 100);
        
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }


}

