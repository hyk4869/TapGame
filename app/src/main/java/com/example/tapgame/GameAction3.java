package com.example.tapgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameAction3 extends AppCompatActivity implements View.OnClickListener {

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_action3);

        count = 1;
        b1 = findViewById(R.id.button1);
        b1.findViewById(R.id.button1).setOnClickListener(this);

        b2 = findViewById(R.id.button2);
        b2.findViewById(R.id.button2).setOnClickListener(this);

        b3 = findViewById(R.id.button3);
        b3.findViewById(R.id.button3).setOnClickListener(this);

        b4 = findViewById(R.id.button4);
        b4.findViewById(R.id.button4).setOnClickListener(this);

        b5 = findViewById(R.id.button5);
        b5.findViewById(R.id.button5).setOnClickListener(this);

        b6 = findViewById(R.id.button6);
        b6.findViewById(R.id.button6).setOnClickListener(this);

        b7 = findViewById(R.id.button7);
        b7.findViewById(R.id.button7).setOnClickListener(this);

        b8 = findViewById(R.id.button8);
        b8.findViewById(R.id.button8).setOnClickListener(this);

        b9 = findViewById(R.id.button9);
        b9.findViewById(R.id.button9).setOnClickListener(this);

        findViewById(R.id.HomeButton).setOnClickListener(this);
        findViewById(R.id.RetryButton).setOnClickListener(this);

        List<String> number = new ArrayList<String>();
        number.add("1");
        number.add("2");
        number.add("3");
        number.add("4");
        number.add("5");
        number.add("6");
        number.add("7");
        number.add("8");
        number.add("9");

        Collections.shuffle(number);

        b1.setText(number.get(0));
        b2.setText(number.get(1));
        b3.setText(number.get(2));
        b4.setText(number.get(3));
        b5.setText(number.get(4));
        b6.setText(number.get(5));
        b7.setText(number.get(6));
        b8.setText(number.get(7));
        b9.setText(number.get(8));
    }

    @Override
    public void onClick(View view) {
        int getID = view.getId();

        if (getID == R.id.button1) {
            if (b1.getText().toString().equals("" + count)) {
                b1.setVisibility((View.INVISIBLE));
                count += 1;
            }
            if (count == 10) {
                Intent intentScoreScreen = new Intent(getApplication(), ScoreZone.class);
                startActivity(intentScoreScreen);
            }
        } else if (getID == R.id.button2) {
            if (b2.getText().toString().equals("" + count)) {
                b2.setVisibility((View.INVISIBLE));
                count += 1;
            }
            if (count == 10) {
                Intent intentScoreScreen = new Intent(getApplication(), ScoreZone.class);
                startActivity(intentScoreScreen);
            }
        } else if (getID == R.id.button3) {
            if (b3.getText().toString().equals("" + count)) {
                b3.setVisibility((View.INVISIBLE));
                count += 1;
            }
            if (count == 10) {
                Intent intentScoreScreen = new Intent(getApplication(), ScoreZone.class);
                startActivity(intentScoreScreen);
            }
        } else if (getID == R.id.button4) {
            if (b4.getText().toString().equals("" + count)) {
                b4.setVisibility((View.INVISIBLE));
                count += 1;
            }
            if (count == 10) {
                Intent intentScoreScreen = new Intent(getApplication(), ScoreZone.class);
                startActivity(intentScoreScreen);
            }
        } else if (getID == R.id.button5) {
            if (b5.getText().toString().equals("" + count)) {
                b5.setVisibility((View.INVISIBLE));
                count += 1;
            }
            if (count == 10) {
                Intent intentScoreScreen = new Intent(getApplication(), ScoreZone.class);
                startActivity(intentScoreScreen);
            }
        } else if (getID == R.id.button6) {
            if (b6.getText().toString().equals("" + count)) {
                b6.setVisibility((View.INVISIBLE));
                count += 1;
            }
            if (count == 10) {
                Intent intentScoreScreen = new Intent(getApplication(), ScoreZone.class);
                startActivity(intentScoreScreen);
            }
        } else if (getID == R.id.button7) {
            if (b7.getText().toString().equals("" + count)) {
                b7.setVisibility((View.INVISIBLE));
                count += 1;
            }
            if (count == 10) {
                Intent intentScoreScreen = new Intent(getApplication(), ScoreZone.class);
                startActivity(intentScoreScreen);
            }
        } else if (getID == R.id.button8) {
            if (b8.getText().toString().equals("" + count)) {
                b8.setVisibility((View.INVISIBLE));
                count += 1;
            }
            if (count == 10) {
                Intent intentScoreScreen = new Intent(getApplication(), ScoreZone.class);
                startActivity(intentScoreScreen);
            }
        } else if (getID == R.id.button9) {
            if (b9.getText().toString().equals("" + count)) {
                b9.setVisibility((View.INVISIBLE));
                count += 1;
            }
            if (count == 10) {
                Intent intentScoreScreen = new Intent(getApplication(), ScoreZone.class);
                startActivity(intentScoreScreen);
            }
        } else if (getID == R.id.HomeButton) {
            Intent intentHome = new Intent(getApplication(), MainActivity.class);
            startActivity(intentHome);
        } else if (getID == R.id.RetryButton) {
            Intent intentRetry = new Intent(getApplication(), GameAction3.class);
            startActivity(intentRetry);
        }

    }
}