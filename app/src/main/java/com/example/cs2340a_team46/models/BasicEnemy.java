package com.example.cs2340a_team46.models;

import com.example.cs2340a_team46.R;

public class BasicEnemy extends Enemy {
    public BasicEnemy() {
        this.sprite = R.drawable.angel; // TODO: change this to not be an angel
        this.movementBehavior = new NormalMovement(); // TODO: change this @Ryan
    }
}
