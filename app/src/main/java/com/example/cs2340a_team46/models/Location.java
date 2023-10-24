package com.example.cs2340a_team46.models;

public class Location {
    private static final double RV = 100.0; // RV for roundingValue. this should be some power of 10
    private static final double MOE = 1.0 / RV; // Margin of Error for comparisons
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location other = (Location) o;
        return Math.abs(other.x - this.x) < MOE && Math.abs(other.y - this.y) < MOE;
    }

    // TODO : set a limit here so you can't move the player off the map?
    // this is kinda redundant cus we already check collisions, but it couldn't hurt
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

    public double[] getXY() {
        return new double[] {this.x, this.y};
    }

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
