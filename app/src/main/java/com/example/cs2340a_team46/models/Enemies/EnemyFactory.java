package com.example.cs2340a_team46.models.Enemies;

import com.example.cs2340a_team46.models.Enemies.Enemy;

public abstract class EnemyFactory {
    public Enemy generateEnemy() {
        Enemy enemy = createEnemy();
        // do something here, "prepare" the enemy, idk
        return enemy;
    }

    protected abstract Enemy createEnemy();
}
