package com.example.cs2340a_team46.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;
import android.util.Log;

import com.example.cs2340a_team46.R;

public class Tilemap extends View {
    private Bitmap bricks;
    private Bitmap dirt;
    private Bitmap floor_1;
    private Bitmap floor_2;
    private Bitmap floor_3;
    private Bitmap floor_4;
    private Bitmap floor_5;
    private Bitmap floor_6;
    private Bitmap floor_7;
    private Bitmap floor_8;
    private Bitmap wall_hole_1;
    private Bitmap wall_hole_2;
    private Bitmap wall_left;
    private Bitmap wall_mid;
    private Bitmap wall_right;
    private Bitmap knight;
    private Log log;
    private static int[][] tilemapFlip = {
            {1,1,1,7,1,2,1,1,1,6,1,4,1,1,6,1,1,1,2,2},
            {1,1,11,12,13,11,12,13,11,12,13,11,12,13,11,12,13,11,1,1},
            {1,1,1,7,1,2,1,1,1,6,1,4,1,1,6,1,1,1,5,1},
            {1,1,1,1,6,1,1,1,7,1,1,1,1,1,5,1,5,1,1,1},
            {1,1,1,8,1,1,2,1,1,2,1,1,1,1,2,1,1,1,5,1},
            {5,3,1,3,1,1,1,1,1,1,1,4,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,7,1,1,1,1,1,1,7,1,1},
            {1,5,1,1,6,1,4,1,1,6,1,1,4,1,1,8,1,4,1,1},
            {1,1,1,1,3,1,1,1,1,6,1,1,6,1,1,1,1,8,1,1},
            {1,1,1,1,1,3,1,1,1,1,1,3,1,1,3,7,1,6,1,1},
            {1,3,1,7,1,1,8,1,1,5,1,1,1,1,1,1,1,1,1,1},
            {1,1,11,12,13,11,12,13,11,12,13,11,12,13,11,12,13,11,1,1},
    };
    private static int[][] tileMap;

    public Tilemap(Context context){
        super(context);
        bricks = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.bricks);
        dirt = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.dirt);
        floor_1 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.floor_1);
        floor_2 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.floor_2);
        floor_3 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.floor_3);
        floor_4 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.floor_4);
        floor_5 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.floor_5);
        floor_6 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.floor_6);
        floor_7 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.floor_7);
        floor_8 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.floor_8);
        wall_hole_1 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.wall_hole_1);
        wall_hole_2 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.wall_hole_2);
        wall_left = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.wall_left);
        wall_mid = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.wall_mid);
        wall_right = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.wall_right);
        knight = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.knight);
        tileMap = new int[20][12];
        for(int i = 0; i < tilemapFlip.length; i++) {
            for (int j = 0; j < tilemapFlip[0].length; j++) {
                tileMap[j][i] = tilemapFlip[i][j];
            }
        }
    }
    public void drawTilemap(Canvas canvas) {
        for(int r = 0; r < tileMap.length; r++) {
            for (int c = 0; c < tileMap[0].length; c++) {
                if (tileMap[r][c] == 0) {
                    //nothing
                }else if (tileMap[r][c] == 1) {
                    canvas.drawBitmap(floor_1, r * 128, c * 128, null);
                } else if (tileMap[r][c] == 2) {
                    canvas.drawBitmap(floor_2, r * 128, c * 128, null);
                } else if (tileMap[r][c] == 3) {
                    canvas.drawBitmap(floor_3, r * 128, c * 128, null);
                } else if (tileMap[r][c] == 4) {
                    canvas.drawBitmap(floor_4, r * 128, c * 128, null);
                } else if (tileMap[r][c] == 5) {
                    canvas.drawBitmap(floor_5, r * 128, c * 128, null);
                } else if (tileMap[r][c] == 6) {
                    canvas.drawBitmap(floor_6, r * 128, c * 128, null);
                } else if (tileMap[r][c] == 7) {
                    canvas.drawBitmap(floor_7, r * 128, c * 128, null);
                } else if (tileMap[r][c] == 8) {
                    canvas.drawBitmap(floor_8, r * 128, c * 128, null);
                } else if (tileMap[r][c] == 9) {
                    canvas.drawBitmap(wall_hole_1, r * 128, c * 128, null);
                } else if (tileMap[r][c] == 10) {
                    canvas.drawBitmap(wall_hole_2, r * 128, c * 128, null);
                } else if (tileMap[r][c] == 11) {
                    canvas.drawBitmap(wall_left, r * 128, c * 128, null);
                } else if (tileMap[r][c] == 12) {
                    canvas.drawBitmap(wall_mid, r * 128, c * 128, null);
                } else if (tileMap[r][c] == 13) {
                    canvas.drawBitmap(wall_right, r * 128, c * 128, null);
                }
            }
        }
    }

//    public static int[] getTileIndex(double coord1, double coord2) {
//        int[] arr = {(int)coord1/64, (int)coord2/64};
//        return arr;
//    }
    public static boolean getIfCollide(double coord1, double coord2) {
        Log.d("Priorx", "Xvalue: "+coord1);
        Log.d("Prioy", "YValue: "+coord2);
        int x = Math.abs((int)coord1/128);
        int y = Math.abs((int)coord2/128);
        Log.d("x", "Xvalue: "+x);
        Log.d("y", "YValue: "+y);
        if(tileMap[x][y] == 9 || tileMap[x][y] == 10 || tileMap[x][y] == 11 || tileMap[x][y] == 12
                || tileMap[x][y] == 13) {
            return true;
        }
        return false;
    }



}
