package com.example.cs2340a_team46.models;

import android.content.Context;

public class Tilemap1 extends Tilemap {

    public Tilemap1(Context context) {
        super(context);
        this.tileMapFlip = new int[][] {
            {1,  1,  1,  7,  1,  2,  1,  1,  1,  6,  1,  4,  1,  1,  6,  1,  1,  1,  1, 1},
            {1, 14, 11, 12, 13, 11, 12, 13, 11, 12, 13, 11, 12, 13, 11, 12, 13, 11, 15, 1},
            {1,  1,  1,  7,  1,  2,  1,  1,  1,  6,  1,  4,  1,  1,  6,  1,  1,  1,  5, 1},
            {1,  1,  1,  1,  6,  1,  1,  1,  7,  1,  1,  1,  1,  1,  5,  1,  5,  1,  1, 1},
            {1,  1,  1,  8,  1,  1,  2,  1,  1,  2,  1,  1,  1,  1,  2,  1,  1,  1,  5, 1},
            {5,  3,  1,  3,  1,  1,  1,  1,  1,  1,  1,  4,  1,  1,  1,  1,  1,  1,  1, 1},
            {1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  7,  1,  1,  1,  1,  1,  1,  7,  1, 1},
            {1,  5,  1,  1,  6,  1,  4,  1,  1,  6,  1,  1,  4,  1,  1,  8,  1,  4,  1, 1},
            {1,  1,  1,  1,  3,  1,  1,  1,  1,  6,  1,  1,  6,  1,  1,  1,  1,  8,  1, 1},
            {1,  1,  1,  1,  1,  3,  1,  1,  1,  1,  1,  3,  1,  1,  3,  7,  1,  6,  1, 1},
            {1,  3,  1,  7,  1,  1,  8,  1,  1,  5,  1,  1,  1,  1,  1,  1,  1,  1,  1, 1},
            {1, 13, 11, 12, 13, 11, 12, 13, 11, 12, 13, 11, 12, 13, 11, 12, 13, 11, 12, 1}
        };

        this.tileMapLayer2Flip = new int[][] {
            {0, 22, 20, 21, 22, 20, 21, 22, 20, 21, 22, 20, 21, 22, 20, 21, 22, 20, 21, 0},
            {0, 17,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 16, 0},
            {0, 17,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 16, 0},
            {0, 17,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 16, 0},
            {0, 17,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 16, 0},
            {0, 17,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 16, 0},
            {0, 17,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  29,  0,  0,  0, 16, 0},
            {0, 17,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 16, 0},
            {0, 17,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 16, 0},
            {0, 17,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 16, 0},
            {0, 23, 20, 21, 22, 20, 21, 22, 20, 21, 22, 20, 21, 22, 20, 25, 22, 20, 24, 0},
            {0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0}
        };

        loadVars();
    }

}
