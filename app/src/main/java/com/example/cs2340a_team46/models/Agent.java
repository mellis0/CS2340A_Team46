package com.example.cs2340a_team46.models;

import java.util.Observable;

public abstract class Agent extends Observable {
    protected MovementBehavior movementBehavior;
    protected int health;
    protected Location location;


    public void setMovementBehavior(MovementBehavior mb) {
        this.movementBehavior = mb;
    }

    public MovementBehavior getMovementBehavior() {
        return this.movementBehavior;
    }

    // getter and setter for health
    public void setHealth(int playerHealth) {
        this.health = playerHealth;
    }
    public int getHealth() {
        return health;
    }

    public void setX(double x) {
        this.location.setX(x);
    }
    public void setY(double y) {
        this.location.setY(y);
    }
    public void setLocation(double x, double y) {
        this.setX(x);
        this.setY(y);
    }
    public double getX() {
        return this.location.getX();
    }
    public double getY() {
        return this.location.getY();
    }
    public Location getLocation() {
        return this.location;
    }

    public double[] getLocationArr() {
        return this.location.getXY();
    }


    public void updateLoc(Tilemap tilemap, Location joystickLoc, boolean collideCheck) {
        this.movementBehavior.move(tilemap, this.location, joystickLoc, collideCheck);

        setChanged();
        notifyObservers();
    }
}
