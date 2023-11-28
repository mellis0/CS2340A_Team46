package com.example.cs2340a_team46.models.Powerup.DecoratorDisplay;

public class PowerupDecorator implements PowerupDisplay {
    protected PowerupDisplay powerupDisplay;

    public PowerupDecorator(PowerupDisplay p) {
        this.powerupDisplay = p;
    }
    @Override
    public String displayPowerupStr() {
        return this.powerupDisplay.displayPowerupStr();
    }
}
