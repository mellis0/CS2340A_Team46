package com.example.cs2340a_team46.models.Enemies;

import com.example.cs2340a_team46.R;
import com.example.cs2340a_team46.models.Player;
// import com.example.cs2340a_team46.models.NormalMovement;

public class BasicEnemy extends Enemy {
    public BasicEnemy(Player player) {
        super(player);
        this.sprite = R.drawable.skeleton;
        this.movementBehavior = new EnemyBasicMovement();
    }
}
