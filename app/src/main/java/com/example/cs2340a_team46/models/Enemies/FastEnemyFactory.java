package com.example.cs2340a_team46.models.Enemies;

import com.example.cs2340a_team46.models.Enemies.Enemy;
import com.example.cs2340a_team46.models.Enemies.EnemyFactory;
import com.example.cs2340a_team46.models.Enemies.FastEnemy;

public class FastEnemyFactory extends EnemyFactory {
    @Override
    protected Enemy createEnemy() {
        return new FastEnemy();
    }
}
