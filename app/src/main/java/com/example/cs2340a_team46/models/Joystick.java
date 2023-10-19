package com.example.cs2340a_team46.models;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Joystick {

    private float outerX;
    private float outerY;
    private float innerX;
    private float innerY;
    private float outerRadius;
    private float innerRadius;
    private boolean isPressed;
    private double distance;

    public Joystick() {
        outerX = 275;
        outerY = 1200;
        innerX = 275;
        innerY = 1200;
        outerRadius = 70;
        innerRadius = 40;
        isPressed = false;
        distance = 0;
    }

    public void drawJoystick(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(3);

        Paint blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStyle(Paint.Style.STROKE);
        blackPaint.setStrokeWidth(3);

        canvas.drawCircle(outerX, outerY, outerRadius, blackPaint);
        canvas.drawCircle(innerX, innerY, innerRadius, p);
        if (getDistance() < outerRadius) {

        }
    }

    public void setInner(float x, float y) {
        innerX = x;
        innerY = y;
        updateDistance();
        if (distance > outerRadius) {
            //Far distance is 'distance', close distance is 'radius'
            float ratioDist = (float)(outerRadius/distance);
            innerX = ((1-ratioDist) * outerX+(ratioDist * innerX));
            innerY = ((1-ratioDist) * outerY+(ratioDist * innerY));
        }
    }
    public void updateDistance() {
        double deltaX = innerX - 275;
        double deltaY = innerY - 1200;
        distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
    public double getDistance() {
        return distance;
    }
    public boolean isPressed() {
        if (distance < outerRadius) {
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
    public float getInnerX() {
        return innerX;
    }
    public float getInnerY() {
        return innerY;
    }

}
