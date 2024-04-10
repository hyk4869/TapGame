package com.example.tapgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreZone extends AppCompatActivity implements View.OnClickListener {
    /**
     * データ保存用の変数
     */
    public SharedPreferences pref;
    private TextView timeText;
    private TextView timeTitle;
    private TextView newScoreText;
    private TextView highScoreText;
    private String score;
    private String score1;

    private final SharedPreferences.OnSharedPreferenceChangeListener scoreListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if (key != null && key.equals("score1")) {
                String score1 = sharedPreferences.getString("score1", "00:00:00");
                timeText.setText(score1);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_zone);

        this.pref = getSharedPreferences("pref", MODE_PRIVATE);
        pref.registerOnSharedPreferenceChangeListener(this.scoreListener);


        Intent intent = getIntent();
        this.score = intent.getStringExtra("score");

        this.timeTitle = findViewById((R.id.timeTitle));
        this.newScoreText = findViewById((R.id.newScoreText));
        this.highScoreText = findViewById((R.id.highScoreText));
        this.timeText = findViewById((R.id.timeText1));

        findViewById(R.id.HomeButton).setOnClickListener(this);
        findViewById(R.id.RetryButton).setOnClickListener(this);
        findViewById(R.id.ResetButton).setOnClickListener(this);

        this.timeTitle.setText(this.score);

        this.score1 = pref.getString("score1", "00:00:00");
        this.timeText.setText(this.score1);


        if (this.score == null) return;
        int m = Integer.parseInt(this.score.substring(0, 2));
        int s = Integer.parseInt(this.score.substring(3, 5));
        int ms = Integer.parseInt(this.score.substring(6, 8));

        int m1 = Integer.parseInt(this.score1.substring(0, 2));
        int s1 = Integer.parseInt(this.score1.substring(3, 5));
        int ms1 = Integer.parseInt(this.score1.substring(6, 8));


        if (this.score1.equals("00:00:00")) {
            this.updateValue();
        } else {
            if (m < m1) {
                this.updateValue();
            } else if (m == m1) {
                if (s < s1) {
                    this.updateValue();
                } else if (s == s1) {
                    if (ms < ms1) {
                        this.updateValue();
                    }
                }
            }
        }

    }

    /**
     * 値の更新
     */
    private void updateValue() {
        SharedPreferences.Editor editor = this.pref.edit();
        editor.putString("score1", this.score).apply();
        editor.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pref.unregisterOnSharedPreferenceChangeListener(this.scoreListener);
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