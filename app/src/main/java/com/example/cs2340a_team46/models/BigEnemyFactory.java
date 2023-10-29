package com.example.cs2340a_team46.models;

public class BigEnemyFactory extends EnemyFactory {
    @Override
    protected Enemy createEnemy() {
        return new BigEnemy();
    }
}