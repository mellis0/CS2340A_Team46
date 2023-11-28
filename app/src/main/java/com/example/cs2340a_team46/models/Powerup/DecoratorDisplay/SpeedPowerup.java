package com.example.cs2340a_team46.models.Powerup.DecoratorDisplay;

public class SpeedPowerup extends PowerupDecorator{
    public SpeedPowerup(PowerupDisplay p) {
        super(p);
    }
    @Override
    public String displayPowerupStr() {
        if (super.displayPowerupStr().equals("No powerups")) {
            return "Speed Boost";
        }
        return super.displayPowerupStr() + ", Speed Boost";

    }
}
