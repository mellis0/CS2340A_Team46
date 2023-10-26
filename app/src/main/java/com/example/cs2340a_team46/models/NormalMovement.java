package com.example.cs2340a_team46.models;


public class NormalMovement implements MovementBehavior {

    @Override
    public void move(Tilemap tilemap, Location entityLoc,
                     Location joystickLoc, boolean collideCheck) {
        double xSpeed = (joystickLoc.getX() - Joystick.OUTER_X) / 5;
        double ySpeed = (joystickLoc.getY() - Joystick.OUTER_Y) / 5;
        //check x case first
        if (collideCheck) {
            if (!tilemap.getIfCollide(new Location(entityLoc.getX() + xSpeed, entityLoc.getY()))) {
                entityLoc.changeX(xSpeed);
            }
            if (!tilemap.getIfCollide(new Location(entityLoc.getX(), entityLoc.getY() + ySpeed))) {
                entityLoc.changeY(ySpeed);
            }
        } else {
            entityLoc.changeX(xSpeed);
            entityLoc.changeY(ySpeed);
        }
        // return entityLoc;
    }
}
