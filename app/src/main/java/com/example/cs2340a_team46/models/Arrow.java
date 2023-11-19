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
    public Arrow(Location playerLocation, float heading, Resources resources) {
        float degreesHeading = (float) Math.toDegrees(heading);
        degreesHeading += 180;
        degreesHeading = (degreesHeading + 90) % 360;
        degreesHeading -= 180;

        Log.println(Log.DEBUG, "arrow", Float.toString(degreesHeading));
        this.location = playerLocation;
        Bitmap upright = BitmapFactory.decodeResource(resources, R.drawable.arrow);
        Matrix m = new Matrix();
        m.postRotate(degreesHeading); // heading is in radians by default
        bitmap = Bitmap.createBitmap(upright, 0, 0, upright.getWidth(), upright.getHeight(), m, true);

        this.speed = 10;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public float getX() {
        return (float) this.location.getX();
    }

    public float getY() {
        return (float) this.location.getY();
    }
}
