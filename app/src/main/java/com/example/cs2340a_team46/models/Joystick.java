package com.example.cs2340a_team46.models;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Joystick {

    private static final float OUTER_X = 275;
    private static final float OUTER_Y = 1200;
    private static final float OUTER_RADIUS = 70;
    private static final float INNER_RADIUS = 40;
    private static final float INNER_X = 275;
    private static final float INNER_Y = 1200;
    private Location innerLoc;
    private boolean isPressed;
    private double distance;
    private static volatile Joystick instance;

    private Joystick() {
        this.innerLoc = new Location(INNER_X, INNER_Y);
        this.isPressed = false;
        this.distance = 0;
    }

    public static Joystick getInstance() {
        if (instance == null) {
            synchronized (Joystick.class) {
                if (instance == null) {
                    instance = new Joystick();
                }
            }
        }
        return instance;
    }

    public void drawJoystick(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        p.setStyle(Paint.Style.FILL);
//        p.setStrokeWidth(3);

        Paint blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStyle(Paint.Style.STROKE);
        blackPaint.setStrokeWidth(5);

        canvas.drawCircle(OUTER_X, OUTER_Y, OUTER_RADIUS, blackPaint);
        canvas.drawCircle((float) this.innerLoc.getX(), (float) this.innerLoc.getY(), INNER_RADIUS, p);
        if (getDistance() < OUTER_RADIUS) {

        }
    }

    public void setInner(double x, double y) {
        this.innerLoc.setX(x);
        this.innerLoc.setY(y);
        updateDistance();
        if (distance > OUTER_RADIUS) {
            //Far distance is 'distance', close distance is 'radius'
            float ratioDist = (float)(OUTER_RADIUS/distance);
            this.innerLoc.setX((1-ratioDist) * OUTER_X+(ratioDist * this.innerLoc.getX()));
            this.innerLoc.setY((1-ratioDist) * OUTER_Y+(ratioDist * this.innerLoc.getY()));
        }
    }
    public void updateDistance() {
        double deltaX = this.innerLoc.getX() - OUTER_X;
        double deltaY = this.innerLoc.getY() - OUTER_Y;
        distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
    public double getDistance() {
        return distance;
    }
    public boolean isPressed() {
        if (distance < OUTER_RADIUS) {
            isPressed = true;
            return true;
        }
        return false;
    }
    public boolean getPressed() {
        return isPressed;
    }
    public void setPressed(boolean aIsPressed) {
        isPressed = aIsPressed;
    }
    public Location getInnerLoc() {
        return this.innerLoc;
    }
    public float getOuterRadius() {
        return OUTER_RADIUS;
    }

}
