package com.example.tapgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import utils.CompareTime;
import utils.CreateArray;
import utils.ViewPagerAdapter;

public class ScoreZone extends AppCompatActivity implements View.OnClickListener {
    /**
     * データ保存用の変数
     */
    public SharedPreferences pref;
    private TextView timeText1;
    private TextView timeText2;
    private TextView timeText3;
    private TextView timeTitle;
    private TextView newScoreText;
    private TextView highScoreText;
    private String score;
    private String score1;
    private String score2;
    private String score3;

    /**
     * 全てのスコアと新しいスコアを配列にまとめたもの
     */
    private ArrayList<String> scoreArray;
    /**
     * 加工済みの配列
     */
    private ArrayList<String> formattedArray;

    private boolean showNewScoreText = false;

    private CompareTime compareTime = new CompareTime();
    private CreateArray createArray = new CreateArray();

    private ViewPager2 viewPager2;
    private ViewPagerAdapter viewPagerAdapter;

//    private final SharedPreferences.OnSharedPreferenceChangeListener scoreListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
//        @Override
//        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
//            if (key != null && key.equals("score1")) {
//                score1 = sharedPreferences.getString("score1", "00:00:00");
//                timeText1.setText(score1);
//            } else if (key != null && key.equals("score2")) {
//                score2 = sharedPreferences.getString("score2", "00:00:00");
//                timeText2.setText(score2);
//            } else if (key != null && key.equals("score3")) {
//                score3 = sharedPreferences.getString("score3", "00:00:00");
//                timeText3.setText(score3);
//            }
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_zone);

        Intent intent = getIntent();
        this.score = intent.getStringExtra("score");

        viewPager2 = findViewById(R.id.viewPager2);
        viewPagerAdapter = new ViewPagerAdapter(this, this.score);
        viewPager2.setAdapter(viewPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText(getResources().getString(viewPagerAdapter.getTitleId(position)));
        }).attach();

        this.pref = getSharedPreferences("pref", MODE_PRIVATE);
//        pref.registerOnSharedPreferenceChangeListener(this.scoreListener);


//        this.timeTitle = findViewById((R.id.timeTitle));
//        this.newScoreText = findViewById((R.id.newScoreText));
//        this.highScoreText = findViewById((R.id.highScoreText));
//        this.timeText1 = findViewById((R.id.timeText1));
//        this.timeText2 = findViewById((R.id.timeText2));
//        this.timeText3 = findViewById((R.id.timeText3));
//
//        findViewById(R.id.HomeButton).setOnClickListener(this);
//        findViewById(R.id.RetryButton).setOnClickListener(this);
//        findViewById(R.id.ResetButton).setOnClickListener(this);
//
//        this.timeTitle.setText(this.score);
//
//        this.score1 = pref.getString("score1", "00:00:00");
//        this.score2 = pref.getString("score2", "00:00:00");
//        this.score3 = pref.getString("score3", "00:00:00");
//
//        this.timeText1.setText(this.score1);
//        this.timeText2.setText(this.score2);
//        this.timeText3.setText(this.score3);
//
//        this.scoreArray = createArray.createStringArray(this.score, this.score1, this.score2, this.score3);
//
//        this.formattedArray = this.compareTime.parseArrayTime(this.scoreArray);
//
//        this.showNewScoreText = this.compareTime.isShowNewScoreText(this.formattedArray, this.score);
//
//        if (this.showNewScoreText) {
//            this.newScoreText.setVisibility(View.VISIBLE);
//        } else {
//            this.newScoreText.setVisibility(View.INVISIBLE);
//        }
//
//        this.updateValue();
    }

    /**
     * 値の更新
     */
//    private void updateValue() {
//        SharedPreferences.Editor editor = this.pref.edit();
//        editor.putString("score1", this.formattedArray.get(0));
//        editor.putString("score2", this.formattedArray.get(1));
//        editor.putString("score3", this.formattedArray.get(2));
//        editor.apply();
//    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        pref.unregisterOnSharedPreferenceChangeListener(this.scoreListener);
//    }
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
            editor.remove("score1");
            editor.remove("score2");
            editor.remove("score3");
            editor.apply();
        }

    }

}