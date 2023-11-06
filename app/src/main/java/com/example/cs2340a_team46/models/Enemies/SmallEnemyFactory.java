package com.example.cs2340a_team46.models.Enemies;

import com.example.cs2340a_team46.models.Enemies.Enemy;
import com.example.cs2340a_team46.models.Enemies.EnemyFactory;
import com.example.cs2340a_team46.models.Enemies.SmallEnemy;

public class SmallEnemyFactory extends EnemyFactory {
    @Override
    protected Enemy createEnemy() {
        return new SmallEnemy();
    }
}
