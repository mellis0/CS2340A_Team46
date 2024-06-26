package com.example.cs2340a_team46.models;


public class NormalMovement implements MovementBehavior {
    public static int speed = 1;
    @Override
    public void move(Tilemap tilemap, Location entityLoc,
                     Location joystickLoc, boolean collideCheck) {
        double xSpeed = (joystickLoc.getX() - Joystick.OUTER_X) / 5 * speed;
        double ySpeed = (joystickLoc.getY() - Joystick.OUTER_Y) / 5 * speed;
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

    public void moveEnemy(Tilemap tilemap, Location entityLoc, boolean playerLeft,
                          boolean playerRight, boolean playerUp, boolean playerDown,
                          boolean standStill, boolean collideCheck) {
        //nothing cuz this is player
    }
}
