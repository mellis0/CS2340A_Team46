package com.example.cs2340a_team46;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.start_screen);
    }
}
