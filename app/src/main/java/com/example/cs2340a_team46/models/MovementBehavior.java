package com.example.cs2340a_team46.models;

public interface MovementBehavior {
    public void move(Location entityLoc, Location joystickLoc, boolean collideCheck);
}
