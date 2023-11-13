package com.example.cs2340a_team46.models.Enemies;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.models.Player;

public class FastEnemy extends Enemy {
    public FastEnemy(Player player) {
        super(player);
        this.sprite = R.drawable.pumpkin;
        this.movementBehavior = new EnemyHiderMovement();
    }
}
