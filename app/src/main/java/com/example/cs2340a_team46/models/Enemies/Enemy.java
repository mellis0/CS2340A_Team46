package com.example.cs2340a_team46.models.Enemies;

import com.example.cs2340a_team46.models.Agent;
import com.example.cs2340a_team46.models.Location;
import com.example.cs2340a_team46.models.Player;
import com.example.cs2340a_team46.models.Tilemap;

import java.util.Observable;
import java.util.Observer;

public abstract class Enemy extends Agent implements Observer {
    protected Location playerLocation;
    public long lastDamageTime = 0;
    public boolean isDamagingPlayer = false;
    protected double cumDamage = 0;
    static final double DAMAGE_RATIO = 5;
    protected int pointsWhenKilled;
    public Enemy(Player player) {
        super();
        player.addObserver(this);
    }
    public int getPointsWhenKilled() {
        return pointsWhenKilled;
    }

    public void update(Observable observable, Object o) {
        Player player = ((Player) observable);
        this.playerLocation = ((Agent) observable).getLocation();
        long currTime = System.currentTimeMillis();
        if (this.checkPlayerCollision()) {
            if (isDamagingPlayer) {
                double damage = DAMAGE_RATIO * player.getDifficultyInt()
                        * 0.001 * (currTime - lastDamageTime);
                double newHealth = Math.max(player.getHealth() - damage, 0);
                cumDamage += damage;
                player.setHealth(newHealth);

                // player.setPlayerName(""+cumDamage);
                lastDamageTime = currTime;
            } else {
                lastDamageTime = currTime;
                isDamagingPlayer = true;
            }
        } else {
            isDamagingPlayer = false;
        }
    }
    public void updateLoc(Tilemap tilemap, boolean playerLeft, boolean playerRight,
                          boolean playerUp, boolean playerDown, boolean standStill,
                          boolean collideCheck) {
        this.movementBehavior.moveEnemy(tilemap, this.location, playerLeft, playerRight, playerUp,
                playerDown, standStill, collideCheck);

        setChanged();
        notifyObservers();
    }
//    public void updatePlayerLoc(Player player, Location playerLocation) {
//        this.playerLocation = playerLocation;
//        long currTime = System.currentTimeMillis();
//        if (this.checkPlayerCollision()) {
//            if (isDamagingPlayer) {
//                double damage = DAMAGE_RATIO * player.getDifficultyInt()
//                        * 0.001 * (currTime - lastDamageTime);
//                double newHealth = Math.max(player.getHealth() - damage, 0);
//                cumDamage += damage;
//                player.setHealth(newHealth);
//
//                // player.setPlayerName(""+cumDamage);
//                lastDamageTime = currTime;
//            } else {
//                lastDamageTime = currTime;
//                isDamagingPlayer = true;
//            }
//        } else {
//            isDamagingPlayer = false;
//        }
//
//    }
    public void resetLastDamageTime() {
        lastDamageTime = System.currentTimeMillis();
    }
    protected boolean checkPlayerCollision() {
        double dx = (this.location.getX() - this.playerLocation.getX());
        double dy = (this.location.getY() - this.playerLocation.getY());
        return Math.sqrt(dx * dx + dy * dy) < 15;
    }

    public boolean checkArrowCollision(Location arrowLoc) {
        double dx = (this.location.getX() - arrowLoc.getX());
        double dy = (this.location.getY() - arrowLoc.getY());
        return Math.sqrt(dx * dx + dy * dy) < 100;
    }
}
