package com.example.cs2340a_team46.models.Enemies;

import com.example.cs2340a_team46.R;

public class SmallEnemy extends Enemy {
    public SmallEnemy() {
        super();
        this.sprite = R.drawable.orc;
        this.movementBehavior = new EnemyDetectMovement();
    }
}
