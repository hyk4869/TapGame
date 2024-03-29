package com.example.tapgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreZone extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_zone);

        Intent intent = getIntent();
        String score = intent.getStringExtra("score");

        TextView newScoreText = findViewById((R.id.newScoreText));
        TextView scoreText = findViewById((R.id.scoreText));
        TextView timeText = findViewById((R.id.timeText));

        timeText.setText(score);
        
        findViewById(R.id.HomeButton).setOnClickListener(this);
        findViewById(R.id.RetryButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int getID = view.getId();
        if (getID == R.id.HomeButton) {
            Intent intentHome = new Intent(getApplication(), MainActivity.class);
            startActivity(intentHome);
        } else if (getID == R.id.RetryButton) {
            Intent intentRetry = new Intent(getApplication(), GameAction3.class);
            startActivity(intentRetry);
        }

    }

}