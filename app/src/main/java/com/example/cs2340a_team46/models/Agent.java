package com.example.cs2340a_team46.models;

import java.util.Observable;

public abstract class Agent extends Observable {
    protected MovementBehavior movementBehavior;
    protected double health;
    protected Location location;
    protected int sprite;


    public void setMovementBehavior(MovementBehavior mb) {
        this.movementBehavior = mb;
    }

    public MovementBehavior getMovementBehavior() {
        return this.movementBehavior;
    }

    // getter and setter for health
    public void setHealth(double health) {
        this.health = health;
    }
    public double getHealth() {
        return health;
    }

    public int getSprite() {
        return sprite;
    }

    public void setX(double x) {
        this.location.setX(x);
    }
    public void setY(double y) {
        this.location.setY(y);
    }
    public void setLocation(double x, double y) {
        if (this.location == null) {
            this.location = new Location(x, y);
        } else {
            this.setX(x);
            this.setY(y);
        }
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
