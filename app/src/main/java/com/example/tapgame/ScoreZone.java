package com.example.tapgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreZone extends AppCompatActivity implements View.OnClickListener {

    public SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_zone);

        pref = getSharedPreferences("pref", MODE_PRIVATE);

        Intent intent = getIntent();
        String score = intent.getStringExtra("score");

        TextView timeTitle = findViewById((R.id.timeTitle));
        TextView newScoreText = findViewById((R.id.newScoreText));
        TextView highScoreText = findViewById((R.id.highScoreText));
        TextView timeText = findViewById((R.id.timeText));

        findViewById(R.id.HomeButton).setOnClickListener(this);
        findViewById(R.id.RetryButton).setOnClickListener(this);
        findViewById(R.id.ResetButton).setOnClickListener(this);

        timeTitle.setText(score);

        String score1 = pref.getString("score1", "00:00:00");
        timeText.setText(score1);

        assert score != null;
        Integer m = Integer.parseInt(score.substring(0, 2));
        Integer s = Integer.parseInt(score.substring(3, 5));
        Integer ms = Integer.parseInt(score.substring(6, 8));

        Integer m1 = Integer.parseInt(score1.substring(0, 2));
        Integer s1 = Integer.parseInt(score1.substring(3, 5));
        Integer ms1 = Integer.parseInt(score1.substring(6, 8));

        System.out.println(m);
        System.out.println(s);
        System.out.println(ms);
        System.out.println(m1);
        System.out.println(s1);
        System.out.println(ms1);

//        if (m <= m1) {
//            if (s <= s1) {
//                if (ms <= ms1) {
//                    SharedPreferences.Editor editor = pref.edit();
//                    editor.putString("score1", score).apply();
//                    editor.commit();
//                } else {
//                    newScoreText.setText("####");
//                }
//            } else {
//                newScoreText.setText("!!!!");
//            }
//        } else {
//            newScoreText.setText("???");
//        }
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("score1", score).apply();
        editor.commit();

        System.out.println(score1);
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
        } else if (getID == R.id.ResetButton) {
            SharedPreferences.Editor editor = pref.edit();
            editor.remove("score1").apply();
            editor.commit();
        }

    }

}