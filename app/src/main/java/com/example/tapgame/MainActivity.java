package com.example.tapgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.start).setOnClickListener(this);
        findViewById(R.id.score).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.start) {
            Intent intentLevel = new Intent(getApplication(), GameLevel.class);
            startActivity(intentLevel);
        } else if (view.getId() == R.id.score) {
            Intent intentScore = new Intent(getApplication(), ScoreZone.class);
            intentScore.putExtra("score1", "00:00:00");
            startActivity(intentScore);
        }

    }
}