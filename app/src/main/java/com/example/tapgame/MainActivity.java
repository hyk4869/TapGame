package com.example.tapgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);

        findViewById(R.id.start).setOnClickListener(this);
        findViewById(R.id.score).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.start) {
            Intent intentLevel = new Intent(getApplication(), GameLevel.class);
            startActivity(intentLevel);
        } else if (view.getId() == R.id.score) {
            Intent intentScore = new Intent(getApplication(), HighScore.class);
            startActivity(intentScore);
        }

    }

}