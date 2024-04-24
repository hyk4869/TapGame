package com.example.tapgame;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import utils.CreateArray;
import variablesDatas.CommonButtons;
import variablesDatas.VariablesButtonsFour;

public class GameAction4 extends AppCompatActivity implements Runnable, View.OnClickListener {

    private VariablesButtonsFour generateButtons;
    private CommonButtons commonButtons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_action4);

        CreateArray createNumberArray = new CreateArray();

        generateButtons = new VariablesButtonsFour(this);
        commonButtons = new CommonButtons(this);
    }

    @Override
    public void run() {
    }

    @Override
    public void onClick(View view) {
    }
}