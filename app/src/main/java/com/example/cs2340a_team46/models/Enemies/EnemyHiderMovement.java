package com.example.cs2340a_team46.models.Enemies;

import com.example.cs2340a_team46.models.Location;
import com.example.cs2340a_team46.models.MovementBehavior;
import com.example.cs2340a_team46.models.Player;
import com.example.cs2340a_team46.models.Tilemap;

public class EnemyHiderMovement implements MovementBehavior {
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
        double xSpeed = -unitVectorX * 10;
        double ySpeed = -unitVectorY * 10;

        if ((playerLeft && enemyX < playerX) || (!playerLeft && enemyX > playerX)
                || (playerUp && enemyY < playerY)
            || (!playerUp && enemyY > playerY)) {
            xSpeed = 0;
            ySpeed = 0;
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
    }
}
