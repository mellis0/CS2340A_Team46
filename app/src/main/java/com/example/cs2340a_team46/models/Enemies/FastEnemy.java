package com.example.cs2340a_team46.models.Enemies;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.models.Enemies.Enemy;
import com.example.cs2340a_team46.models.NormalMovement;

public class FastEnemy extends Enemy {
    public FastEnemy() {
        super();
        this.sprite = R.drawable.pumpkin;
        this.movementBehavior = new EnemyHiderMovement(); // TODO: change this @Ryan
    }
}
