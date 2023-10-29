package com.example.cs2340a_team46.models;

import com.example.cs2340a_team46.R;

public class FastEnemy extends Enemy {
    public FastEnemy() {
        super();
        this.sprite = R.drawable.pumpkin;
        this.movementBehavior = new NormalMovement(); // TODO: change this @Ryan
    }
}
