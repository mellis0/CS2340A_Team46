package com.example.cs2340a_team46.models.Enemies;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.models.Player;

public class SmallEnemy extends Enemy {
    public SmallEnemy(Player player) {
        super(player);
        this.sprite = R.drawable.orc;
        this.movementBehavior = new EnemyDetectMovement();
    }
}
