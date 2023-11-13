package com.example.cs2340a_team46.models.Enemies;
import com.example.cs2340a_team46.models.Player;

public class BasicEnemyFactory extends EnemyFactory {
    @Override
    protected Enemy createEnemy(Player player) {
        return new BasicEnemy(player);
    }
}
