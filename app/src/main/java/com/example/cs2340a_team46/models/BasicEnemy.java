package com.example.cs2340a_team46.models;

import com.example.cs2340a_team46.R;

public class BasicEnemy extends Enemy {
    public BasicEnemy() {
        super();
        this.sprite = R.drawable.ogre;
        this.movementBehavior = new NormalMovement(); // TODO: change this @Ryan
    }
}
