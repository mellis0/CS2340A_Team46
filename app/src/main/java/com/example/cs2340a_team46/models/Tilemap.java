package com.example.cs2340a_team46.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;
import android.util.Log;

import com.example.cs2340a_team46.R;

public abstract class Tilemap extends View {
    protected Bitmap[] tiles;
    protected static int[][] TILEMAP_FLIP;
    protected static int[][] TILE_MAP_LAYER_2_FLIP;
    protected static int[][] tileMap;
    protected static int[][] tileMapLayer2;
    protected Log log;

    protected static final int[] DRAWABLES = {
        R.drawable.empty,
        R.drawable.floor_1,
        R.drawable.floor_2,
        R.drawable.floor_3,
        R.drawable.floor_4,
        R.drawable.floor_5,
        R.drawable.floor_6,
        R.drawable.floor_7,
        R.drawable.floor_8,
        R.drawable.wall_hole_1,
        R.drawable.wall_hole_2,
        R.drawable.wall_left,
        R.drawable.wall_mid,
        R.drawable.wall_right,
        R.drawable.wall_edge_left,
        R.drawable.wall_edge_right,
        R.drawable.wall_outer_mid_left,
        R.drawable.wall_outer_mid_right,
        R.drawable.wall_outer_top_left,
        R.drawable.wall_outer_top_right,
        R.drawable.wall_top_left,
        R.drawable.wall_top_mid,
        R.drawable.wall_top_right,
        R.drawable.wall_edge_bottom_left,
        R.drawable.wall_edge_bottom_right,
        R.drawable.big_yellow_flask,
        R.drawable.bricks,
        R.drawable.dirt,
        R.drawable.knight
    };

    public Tilemap(Context context) {
        this(context, TILEMAP_FLIP, TILE_MAP_LAYER_2_FLIP);
    }

    public Tilemap(Context context, int[][] tileMapFlip, int[][] tileMapLayer2Flip) {
        super(context);
        this.tiles = new Bitmap[DRAWABLES.length];
        for (int i = 0; i < DRAWABLES.length; i++) {
            this.tiles[i] = BitmapFactory.decodeResource(getContext().getResources(), DRAWABLES[i]);
        }

        // flip the 2d array literal from above b/c the screen is indexed from the top left
        tileMap = flip(tileMapFlip);

        tileMapLayer2 = flip(tileMapLayer2Flip);
    }
    public void drawTilemap(Canvas canvas) {
        for (int r = 0; r < tileMap.length; r++) {
            for (int c = 0; c < tileMap[0].length; c++) {
                canvas.drawBitmap(this.tiles[tileMap[r][c]], r * 128, c * 128, null);
            }
        }
        for (int r = 0; r < tileMapLayer2.length; r++) {
            for (int c = 0; c < tileMapLayer2[0].length; c++) {
                canvas.drawBitmap(this.tiles[tileMapLayer2[r][c]], r * 128, c * 128, null);
            }
        }
    }


    public static boolean getIfCollide(Location loc) {
        double coord1 = loc.getX();
        double coord2 = loc.getY();
        int x = Math.abs((int) coord1 / 128);
        int y = Math.abs((int) coord2 / 128);
        if (tileMap[x][y] == 9 || tileMap[x][y] == 10 || tileMap[x][y] == 11 || tileMap[x][y] == 12
                || tileMap[x][y] == 13 || tileMap[x][y] == 14 || tileMap[x][y] == 15) {
            return true;
        } else if ((tileMapLayer2[x][y] == 16 && coord1 / 128.0 - x > 0.5)
                || (tileMapLayer2[x][y] == 17 && coord1 / 128.0 - x < 0.5)
            || tileMapLayer2[x][y] == 23 || tileMapLayer2[x][y] == 24) {
            return true;
        }
        return false;
    }

    public static boolean getIfFlask(Location loc) {
        double coord1 = loc.getX();
        double coord2 = loc.getY();
        int x = Math.abs((int) coord1 / 128);
        int y = Math.abs((int) coord2 / 128);
        return tileMapLayer2[x][y] == 25;
    }

    protected static int[][] flip(int[][] mat) {
        int[][] out = new int[mat[0].length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                out[j][i] = mat[i][j];
            }
        }
        return out;
    }

}
