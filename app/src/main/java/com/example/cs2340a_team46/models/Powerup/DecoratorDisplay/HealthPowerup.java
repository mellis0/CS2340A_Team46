package com.example.cs2340a_team46.models.Powerup.DecoratorDisplay;

public class HealthPowerup extends PowerupDecorator {
    public HealthPowerup(PowerupDisplay p) {
        super(p);
    }
    @Override
    public String displayPowerupStr() {
        if (super.displayPowerupStr().equals("No powerups")) {
            return "Health Boost";
        }
        return super.displayPowerupStr() + ", Health Boost";
    }
}
