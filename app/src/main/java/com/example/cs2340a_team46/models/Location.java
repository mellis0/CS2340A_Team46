package com.example.cs2340a_team46.models;

import java.util.Objects;

public class Location {
    private static final double RV = 100.0; // RV for roundingValue. this should be some power of 10
    private double x;
    private double y;

    private static double round(double cord) {
        return round(cord, RV);
    }

    private static double round(double cord, double definedRV) {
        return Math.round(cord * definedRV) / definedRV;
    }

    @Override
    public String toString() {
        return "(" + round(x) + ", " + round(y) + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location other = (Location) o;
        return Math.abs(other.x -this.x) < 1 / RV && Math.abs(other.y - this.y) < 1 / RV;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Location(float x, double y) {
        this.x = (float) x;
        this.y = (float) y;
    }
}
