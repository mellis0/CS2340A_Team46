package com.example.cs2340a_team46.models.Powerup;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.models.Location;

public class HealthBoost extends Powerup {
    public HealthBoost(float x, float y) {
        this.drawable = R.drawable.health_pot;
        this.location = new Location(x, y);
    }
}
