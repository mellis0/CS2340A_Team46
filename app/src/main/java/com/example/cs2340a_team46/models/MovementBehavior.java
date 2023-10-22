package com.example.cs2340a_team46.models;

public interface MovementBehavior {
    public double[] move(double charX, double charY, double joystick_x, double joystick_y, boolean collideCheck);
}
