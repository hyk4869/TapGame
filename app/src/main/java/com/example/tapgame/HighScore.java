package com.example.tapgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HighScore extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        findViewById(R.id.threeButton).setOnClickListener(this);
        findViewById(R.id.fourButton).setOnClickListener(this);
        findViewById(R.id.fiveButton).setOnClickListener(this);
        findViewById(R.id.scoreButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int getID = view.getId();

        if (getID == R.id.threeButton) {
            return;
        } else if (getID == R.id.fourButton) {
            return;
        } else if (getID == R.id.fiveButton) {
            return;
        } else if (getID == R.id.scoreButton) {
            Intent intentHome = new Intent(getApplication(), MainActivity.class);
            startActivity(intentHome);
        }
    }
}