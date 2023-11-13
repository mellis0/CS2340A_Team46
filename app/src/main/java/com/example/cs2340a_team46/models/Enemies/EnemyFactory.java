package com.example.cs2340a_team46.models.Enemies;
import com.example.cs2340a_team46.models.Player;

public abstract class EnemyFactory {
    public Enemy generateEnemy(Player player) {
        Enemy enemy = createEnemy(player);
        // do something here, "prepare" the enemy, idk
        return enemy;
    }

    protected abstract Enemy createEnemy(Player player);
}
