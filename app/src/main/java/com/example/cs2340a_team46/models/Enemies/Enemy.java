package com.example.cs2340a_team46.models.Enemies;

import com.example.cs2340a_team46.models.Agent;
import com.example.cs2340a_team46.models.Location;
import com.example.cs2340a_team46.models.Tilemap;

public abstract class Enemy extends Agent {
    // honestly idk what would go here
    public void updateLoc(Tilemap tilemap, boolean playerLeft, boolean playerRight, boolean playerUp, boolean playerDown, boolean standStill, boolean collideCheck) {
        this.movementBehavior.moveEnemy(tilemap, this.location, playerLeft, playerRight, playerUp, playerDown, standStill, collideCheck);

        setChanged();
        notifyObservers();
    }
}
