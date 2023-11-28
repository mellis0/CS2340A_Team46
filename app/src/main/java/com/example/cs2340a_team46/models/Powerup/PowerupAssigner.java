package com.example.cs2340a_team46.models.Powerup;
import com.example.cs2340a_team46.models.Powerup.DecoratorDisplay.BasicPlayer;
import com.example.cs2340a_team46.models.Powerup.DecoratorDisplay.FreezePowerup;
import com.example.cs2340a_team46.models.Powerup.DecoratorDisplay.HealthPowerup;
import com.example.cs2340a_team46.models.Powerup.DecoratorDisplay.PowerupDisplay;
import com.example.cs2340a_team46.models.Powerup.DecoratorDisplay.SpeedPowerup;
import com.example.cs2340a_team46.viewmodels.GameViewModel;

public class PowerupAssigner {
    public static String PowerupText() {
        boolean hp = GameViewModel.health_pot;
        boolean sp = GameViewModel.speed_pot;
        boolean fp = GameViewModel.freeze_pot;
        PowerupDisplay p = new BasicPlayer();
        if (!hp && !sp && !fp) {
            p = new BasicPlayer();
        } else if (hp && sp && fp) {
            p = new HealthPowerup(new SpeedPowerup(new FreezePowerup(new BasicPlayer())));
        } else if (hp && sp) {
            p = new HealthPowerup(new SpeedPowerup(new BasicPlayer()));
        } else if (hp && fp) {
            p = new HealthPowerup(new FreezePowerup(new BasicPlayer()));
        } else if (sp && fp) {
            p = new SpeedPowerup(new FreezePowerup(new BasicPlayer()));
        } else if (hp) {
            p = new HealthPowerup(new BasicPlayer());
        } else if (sp) {
            p = new SpeedPowerup(new BasicPlayer());
        } else if (fp) {
            p = new FreezePowerup(new BasicPlayer());
        }
        return p.displayPowerupStr();
    }

}
