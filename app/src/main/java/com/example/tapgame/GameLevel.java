package com.example.tapgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevel extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_level);

        findViewById(R.id.threeButton).setOnClickListener(this);
        findViewById(R.id.fourButton).setOnClickListener(this);
        findViewById(R.id.scoreButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.button_scale);

        int getID = view.getId();

        if (getID == R.id.threeButton) {
            Intent intentLevel3 = new Intent(getApplication(), GameAction3.class);
            startActivity(intentLevel3);
        } else if (getID == R.id.fourButton) {
            Intent intentLevel4 = new Intent(getApplication(), GameAction4.class);
            startActivity(intentLevel4);
        } else if (getID == R.id.scoreButton) {
            Intent intentScore = new Intent(getApplication(), ScoreZone.class);
            intentScore.putExtra("score1", "00:00:00");
            intentScore.putExtra("score2", "00:00:00");
            intentScore.putExtra("score3", "00:00:00");
            startActivity(intentScore);
        }
        view.startAnimation(anim);

    }
}