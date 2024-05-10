package com.example.tapgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

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
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.button_scale);

        if (view.getId() == R.id.start) {
            Intent intentLevel = new Intent(getApplication(), GameLevel.class);
            startActivity(intentLevel);
        } else if (view.getId() == R.id.score) {
            Intent intentScore = new Intent(getApplication(), ScoreZone.class);
            intentScore.putExtra("score1", "00:00:00");
            intentScore.putExtra("score2", "00:00:00");
            intentScore.putExtra("score3", "00:00:00");
            startActivity(intentScore);
        }
        view.startAnimation(anim);

    }
}