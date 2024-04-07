package com.example.tapgame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import utils.CreateNumberArray;

public class GameAction3 extends AppCompatActivity implements Runnable, View.OnClickListener {

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;

    private Button startButton;
    private Button finishButton;
    private Button isHomeAvailable;
    private Button isRetryAvailable;
    private boolean startPhase;
    private int count;

    private TextView textTime;
    private long startTime;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final SimpleDateFormat date = new SimpleDateFormat("mm:ss:SS", Locale.JAPAN);

    private volatile boolean timePhase = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_action3);

        CreateNumberArray createNumberArray = new CreateNumberArray();

        startPhase = false;
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

        startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(this);

        finishButton = findViewById(R.id.finishButton);
        finishButton.setOnClickListener(this);
        finishButton.setVisibility(View.INVISIBLE);

        isHomeAvailable = findViewById(R.id.HomeButton);
        isHomeAvailable.setOnClickListener(this);

        isRetryAvailable = findViewById(R.id.RetryButton);
        isRetryAvailable.setOnClickListener(this);

        textTime = findViewById(R.id.textTimeView);
        textTime.setText(date.format(0));

        ArrayList<String> numbers = createNumberArray.createArray(9);

        b1.setText(numbers.get(0));
        b2.setText(numbers.get(1));
        b3.setText(numbers.get(2));
        b4.setText(numbers.get(3));
        b5.setText(numbers.get(4));
        b6.setText(numbers.get(5));
        b7.setText(numbers.get(6));
        b8.setText(numbers.get(7));
        b9.setText(numbers.get(8));
    }

    @Override
    public void run() {
        int period = 10;

        while (!timePhase) {
            try {
                Thread.sleep((period));

            } catch (InterruptedException e) {
                e.printStackTrace();
                timePhase = true;
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    long endTime = System.currentTimeMillis();
                    long nowTime = (endTime - startTime);
                    textTime.setText(date.format(nowTime));
                }
            });
        }
    }

    @Override
    public void onClick(View view) {
        Thread thread;
        int getID = view.getId();

        if (getID == R.id.button1) {
            if (startPhase) {
                handleButtonClick(b1);
            }

        } else if (getID == R.id.button2) {
            if (startPhase) {
                handleButtonClick(b2);
            }

        } else if (getID == R.id.button3) {
            if (startPhase) {
                handleButtonClick(b3);
            }

        } else if (getID == R.id.button4) {
            if (startPhase) {
                handleButtonClick(b4);
            }

        } else if (getID == R.id.button5) {
            if (startPhase) {
                handleButtonClick(b5);
            }

        } else if (getID == R.id.button6) {
            if (startPhase) {
                handleButtonClick(b6);
            }

        } else if (getID == R.id.button7) {
            if (startPhase) {
                handleButtonClick(b7);
            }

        } else if (getID == R.id.button8) {
            if (startPhase) {
                handleButtonClick(b8);
            }

        } else if (getID == R.id.button9) {
            if (startPhase) {
                handleButtonClick(b9);
            }

        } else if (getID == R.id.HomeButton) {
            Intent intentHome = new Intent(getApplication(), MainActivity.class);
            startActivity(intentHome);

        } else if (getID == R.id.RetryButton) {
            Intent intentRetry = new Intent(getApplication(), GameAction3.class);
            startActivity(intentRetry);

        } else if (getID == R.id.startButton) {
            startButton.setVisibility((View.INVISIBLE));
            startPhase = true;
            timePhase = false;
            thread = new Thread(this);
            thread.start();
            startTime = System.currentTimeMillis();

        } else if (getID == R.id.finishButton) {
            Intent intentRetry = new Intent(getApplication(), ScoreZone.class);
            intentRetry.putExtra("score", textTime.getText().toString());
            startActivity(intentRetry);
        }

    }

    private void handleButtonClick(Button clickedButton) {
        if (clickedButton.getText().toString().equals("" + count)) {
            clickedButton.setVisibility(View.INVISIBLE);
            count += 1;
        }
        if (count == 10) {
            timePhase = true;
            textTime.setText(date.format(0));
            finishButton.setVisibility((View.VISIBLE));
            isHomeAvailable.setVisibility(View.INVISIBLE);
            isRetryAvailable.setVisibility(View.INVISIBLE);
        }
    }
}