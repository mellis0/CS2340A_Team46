package com.example.cs2340a_team46.models.Powerup.DecoratorDisplay;

public class FreezePowerup extends PowerupDecorator{
    public FreezePowerup(PowerupDisplay p) {
        super(p);
    }
    @Override
    public String displayPowerupStr() {
        if (super.displayPowerupStr().equals("No powerups")) {
            return "Freeze Enemies";
        }
        return super.displayPowerupStr() + ", FreezeEnemies";
    }
}
