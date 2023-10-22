package com.example.cs2340a_team46.models;

import java.sql.Array;

public class NormalMovement implements MovementBehavior {

    @Override
    public double[] move(double charX, double charY, double joystick_x, double joystick_y, boolean collideCheck) {
        double xSpeed = (joystick_x-275)/5;
        double ySpeed = (joystick_y-1200)/5;
        //check x case first
        if (collideCheck){
            if (!Tilemap.getIfCollide(charX+xSpeed, charY)){
                charX += xSpeed;
            }
            if (!Tilemap.getIfCollide(charX, charY+ySpeed)){
                charY += ySpeed;
            }
        } else {
            charX += xSpeed;
            charY += ySpeed;
        }
        double[] out =  new double[2];
        out[0] = charX;
        out[1] = charY;
        return out;
    }
}
