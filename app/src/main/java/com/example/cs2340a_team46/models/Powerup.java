package com.example.cs2340a_team46.models;

public class Powerup {
    protected int drawable;
    protected Location location;
    public int getDrawable() {
        return this.drawable;
    }
    public float getX() {
        return (float) this.location.getX();
    }

    public float getY() {
        return (float) this.location.getY();
    }

    public boolean checkPlayerCollision(Location playerLoc) {
        double dx = (this.location.getX() - playerLoc.getX());
        double dy = (this.location.getY() - playerLoc.getY());
        return Math.sqrt(dx * dx + dy * dy) < 100;
    }
}
