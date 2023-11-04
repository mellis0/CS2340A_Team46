package com.example.cs2340a_team46.models.Enemies;

import com.example.cs2340a_team46.models.Location;
import com.example.cs2340a_team46.models.MovementBehavior;
import com.example.cs2340a_team46.models.Player;
import com.example.cs2340a_team46.models.Tilemap;

public class EnemyRandomMovement implements MovementBehavior {
    @Override
    public void move(Tilemap tilemap,
                     Location entityLoc, Location joystickLoc, boolean collideCheck) {
        //Nothing since this is enemy
    }

    @Override
    public void moveEnemy(Tilemap tilemap, Location entityLoc,
                          boolean playerLeft, boolean playerRight, boolean playerUp, boolean playerDown, boolean standStill, boolean collideCheck) {

        double xSpeed = (Math.random() * 25 - 12.5);
        double ySpeed = (Math.random() * 25 - 12.5);
        if (collideCheck) {
            if (!tilemap.getIfCollide(new Location(entityLoc.getX() + xSpeed, entityLoc.getY()))) {
                entityLoc.changeX(xSpeed);
            }
            if (!tilemap.getIfCollide(new Location(entityLoc.getX(), entityLoc.getY() + ySpeed))) {
                entityLoc.changeY(ySpeed);
            }
        } else {
            entityLoc.changeX(xSpeed);
            entityLoc.changeY(ySpeed);
        }
    }
}