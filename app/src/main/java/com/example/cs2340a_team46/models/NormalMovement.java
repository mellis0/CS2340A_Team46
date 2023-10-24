package com.example.cs2340a_team46.models;

import java.sql.Array;

public class NormalMovement implements MovementBehavior {

    @Override
    public void move(Location entityLoc, Location joystickLoc, boolean collideCheck) {
        double xSpeed = (joystickLoc.getX()-275)/5;
        double ySpeed = (joystickLoc.getY()-1200)/5;
        //check x case first
        if (collideCheck){
            if (!Tilemap.getIfCollide(entityLoc.getX()+xSpeed, entityLoc.getY())){
                entityLoc.changeX(xSpeed);
            }
            if (!Tilemap.getIfCollide(entityLoc.getX(), entityLoc.getY()+ySpeed)){
                entityLoc.changeY(ySpeed);
            }
        } else {
            entityLoc.changeX(xSpeed);
            entityLoc.changeY(ySpeed);
        }
        // return entityLoc;
    }
}
