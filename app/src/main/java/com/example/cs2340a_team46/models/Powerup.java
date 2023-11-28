package com.example.cs2340a_team46.models;

public abstract class Powerup {
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
}
