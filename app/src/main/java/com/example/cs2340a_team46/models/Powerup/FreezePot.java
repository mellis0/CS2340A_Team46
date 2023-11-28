package com.example.cs2340a_team46.models.Powerup;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.models.Location;

public class FreezePot extends Powerup {
    public FreezePot(float x, float y) {
        this.drawable = R.drawable.freeze_pot;
        this.location = new Location(x, y);
    }
}
