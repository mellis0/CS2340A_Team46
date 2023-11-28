package com.example.cs2340a_team46.models.Powerup;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.models.Location;
import com.example.cs2340a_team46.models.Powerup.Powerup;

public class SpeedBoost extends Powerup {
    public SpeedBoost(float x, float y) {
        this.drawable = R.drawable.speed_pot;
        this.location = new Location(x, y);
    }

}
