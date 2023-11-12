package com.example.cs2340a_team46.models.Enemies;

import com.example.cs2340a_team46.R;

public class BasicEnemy extends Enemy {
    public BasicEnemy() {
        super();
        this.sprite = R.drawable.skeleton;
        this.movementBehavior = new EnemyBasicMovement();
    }
}
