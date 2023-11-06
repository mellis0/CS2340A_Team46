package com.example.cs2340a_team46.models.Enemies;

public class BasicEnemyFactory extends EnemyFactory {
    @Override
    protected Enemy createEnemy() {
        return new BasicEnemy();
    }
}
