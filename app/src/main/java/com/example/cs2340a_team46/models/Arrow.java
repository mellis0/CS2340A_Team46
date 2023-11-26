package com.example.cs2340a_team46.models;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.util.Log;

import com.example.cs2340a_team46.R;

public class Arrow {
    private Location location;
    private Bitmap bitmap;
    private double speed;
    private float heading; // in radians
    private int screenHeight;
    private int screenWidth;

    // creates arrow based on location, heading, and resources
    public Arrow(Location playerLocation, float heading, Resources resources) {
        float degreesHeading = (float) Math.toDegrees(heading);
        degreesHeading += 180;
        degreesHeading = (degreesHeading + 90) % 360; // correcting for a 90 degree rotation
        degreesHeading -= 180;

        this.heading = (float) Math.toRadians(degreesHeading);

        Log.println(Log.DEBUG, "arrow", Float.toString(degreesHeading));
        this.location = playerLocation;
        Bitmap upright = BitmapFactory.decodeResource(resources, R.drawable.arrow);
        Matrix m = new Matrix();
        m.postRotate(degreesHeading);
        bitmap = Bitmap.createBitmap(upright, 0, 0, upright.getWidth(), upright.getHeight(), m, true);

        this.speed = 20;

        screenWidth = resources.getSystem().getDisplayMetrics().widthPixels;
        screenHeight = resources.getSystem().getDisplayMetrics().heightPixels;
    }

    // constructor for testing
    public Arrow(Location l, float heading, int w, int h) {
        this.location = l;
        this.heading = heading; // should rotate by 90 here, doesn't matter tho since this is just for testing
        this.speed = 20;
        this.screenWidth = w;
        this.screenHeight = h;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public Location getLocation() {
        return this.location;
    }

    public float getX() {
        return (float) this.location.getX();
    }

    public float getY() {
        return (float) this.location.getY();
    }

    // updated location calculated through sine, cosine.. initial calculations are conducted within the constructor itself
    public void updateLocation() {
        this.location.changeX(this.speed * Math.sin(this.heading));
        this.location.changeY(this.speed * -1 * Math.cos(this.heading));
    }

    // evaluates both in and out of screen arrows
    public boolean outOfScreen() {
        return this.location.getX() < 0
                || this.location.getX() > this.screenWidth
                || this.location.getY() < 0
                || this.location.getY() > this.screenHeight;
    }
}
