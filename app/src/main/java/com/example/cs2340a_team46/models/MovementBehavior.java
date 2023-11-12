package com.example.cs2340a_team46.models;

public interface MovementBehavior {
    public void move(Tilemap tilemap,
                     Location entityLoc, Location joystickLoc, boolean collideCheck);
    public void moveEnemy(Tilemap tilemap, Location entityLoc, boolean playerLeft,
                          boolean playerUp,
                          boolean standStill, boolean collideCheck);
}
