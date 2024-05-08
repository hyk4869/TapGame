package com.example.tapgame;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import utils.ViewPagerAdapter;

public class ScoreZone extends AppCompatActivity {

    private String scoreEasy;
    private String scoreMedium;
    private ViewPager2 viewPager2;
    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_zone);

        Intent intent = getIntent();
        this.scoreEasy = intent.getStringExtra("score_easy");
        this.scoreMedium = intent.getStringExtra("score_medium");

        this.viewPager2 = findViewById(R.id.viewPager2);
        this.viewPagerAdapter = new ViewPagerAdapter(this, this.scoreEasy);
        this.viewPager2.setAdapter(this.viewPagerAdapter);

        this.tabLayout = findViewById(R.id.tabLayout);

        new TabLayoutMediator(this.tabLayout, this.viewPager2, (tab, position) -> {
            tab.setText(getResources().getString(this.viewPagerAdapter.getTitleId(position)));
        }).attach();

    }
}