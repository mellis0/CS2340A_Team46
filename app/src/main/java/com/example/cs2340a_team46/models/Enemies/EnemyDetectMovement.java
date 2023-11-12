package com.example.cs2340a_team46.models.Enemies;

import com.example.cs2340a_team46.models.Location;
import com.example.cs2340a_team46.models.MovementBehavior;
import com.example.cs2340a_team46.models.Player;
import com.example.cs2340a_team46.models.Tilemap;

public class EnemyDetectMovement implements MovementBehavior {
    @Override
    public void move(Tilemap tilemap,
                     Location entityLoc, Location joystickLoc, boolean collideCheck) {
        //Nothing since this is enemy
    }
    @Override
    public void moveEnemy(Tilemap tilemap, Location entityLoc,
                          boolean playerLeft, boolean playerUp,
                          boolean standStill, boolean collideCheck) {
        Player player = Player.getInstance();
        double playerX = player.getX();
        double playerY = player.getY();
        double enemyX = entityLoc.getX();
        double enemyY = entityLoc.getY();
        //Back to calc: Getting a unit vector
        double distanceX = enemyX - playerX;
        double distanceY = enemyY - playerY;
        double magnitude = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
        double unitVectorX = distanceX / magnitude;
        double unitVectorY = distanceY / magnitude;
        double xSpeed = -unitVectorX * 5;
        double ySpeed = -unitVectorY * 5;
        if (standStill) {
            int randomDir = (int) Math.floor(Math.random() * 4 + 1);
            if (randomDir == 1) {
                xSpeed = 10;
                ySpeed = 0;
            } else if (randomDir == 2) {
                xSpeed = -10;
                ySpeed = 0;
            } else if (randomDir == 3) {
                xSpeed = 0;
                ySpeed = 10;
            } else if (randomDir == 4) {
                xSpeed = 0;
                ySpeed = -10;
            }
        }


        //check x case first
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
        // return entityLoc;
    }
}
