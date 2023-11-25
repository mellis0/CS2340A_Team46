package com.example.cs2340a_team46.models.Enemies;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.models.Player;

public class BigEnemy extends Enemy {
    public BigEnemy(Player player) {
        super(player);
        this.pointsWhenKilled = 100;
        this.sprite = R.drawable.ogre;
        this.movementBehavior = new EnemyRandomMovement();
    }
}
