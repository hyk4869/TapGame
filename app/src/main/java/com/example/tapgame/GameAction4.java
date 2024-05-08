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

import utils.CreateArray;
import variablesDatas.CommonButtons;
import variablesDatas.VariablesButtonsFour;

public class GameAction4 extends AppCompatActivity implements Runnable, View.OnClickListener {

    private VariablesButtonsFour generateButtons;
    private CommonButtons commonButtons;
    /**
     * 始まったかどうかを判定するもの
     */
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
        setContentView(R.layout.activity_game_action4);

        CreateArray createNumberArray = new CreateArray();

        generateButtons = new VariablesButtonsFour(this);
        commonButtons = new CommonButtons(this);

        startPhase = false;
        count = 1;

        generateButtons.b1 = findViewById(R.id.button1);
        generateButtons.b1.findViewById(R.id.button1).setOnClickListener(this);

        generateButtons.b2 = findViewById(R.id.button2);
        generateButtons.b2.findViewById(R.id.button2).setOnClickListener(this);

        generateButtons.b3 = findViewById(R.id.button3);
        generateButtons.b3.findViewById(R.id.button3).setOnClickListener(this);

        generateButtons.b4 = findViewById(R.id.button4);
        generateButtons.b4.findViewById(R.id.button4).setOnClickListener(this);

        generateButtons.b5 = findViewById(R.id.button5);
        generateButtons.b5.findViewById(R.id.button5).setOnClickListener(this);

        generateButtons.b6 = findViewById(R.id.button6);
        generateButtons.b6.findViewById(R.id.button6).setOnClickListener(this);

        generateButtons.b7 = findViewById(R.id.button7);
        generateButtons.b7.findViewById(R.id.button7).setOnClickListener(this);

        generateButtons.b8 = findViewById(R.id.button8);
        generateButtons.b8.findViewById(R.id.button8).setOnClickListener(this);

        generateButtons.b9 = findViewById(R.id.button9);
        generateButtons.b9.findViewById(R.id.button9).setOnClickListener(this);

        generateButtons.b10 = findViewById(R.id.button10);
        generateButtons.b10.findViewById(R.id.button10).setOnClickListener(this);

        generateButtons.b11 = findViewById(R.id.button11);
        generateButtons.b11.findViewById(R.id.button11).setOnClickListener(this);

        generateButtons.b12 = findViewById(R.id.button12);
        generateButtons.b12.findViewById(R.id.button12).setOnClickListener(this);

        generateButtons.b13 = findViewById(R.id.button13);
        generateButtons.b13.findViewById(R.id.button13).setOnClickListener(this);

        generateButtons.b14 = findViewById(R.id.button14);
        generateButtons.b14.findViewById(R.id.button14).setOnClickListener(this);

        generateButtons.b15 = findViewById(R.id.button15);
        generateButtons.b15.findViewById(R.id.button15).setOnClickListener(this);

        generateButtons.b16 = findViewById(R.id.button16);
        generateButtons.b16.findViewById(R.id.button16).setOnClickListener(this);

        commonButtons.startButton = findViewById(R.id.startButton);
        commonButtons.startButton.setOnClickListener(this);

        commonButtons.finishButton = findViewById(R.id.finishButton);
        commonButtons.finishButton.setOnClickListener(this);
        commonButtons.finishButton.setVisibility(View.INVISIBLE);

        commonButtons.isHomeAvailable = findViewById(R.id.HomeButton);
        commonButtons.isHomeAvailable.setOnClickListener(this);

        commonButtons.isRetryAvailable = findViewById(R.id.RetryButton);
        commonButtons.isRetryAvailable.setOnClickListener(this);

        this.textTime = findViewById(R.id.textTimeView);
        textTime.setText(date.format(0));

        ArrayList<String> numbers = createNumberArray.createArray(16);

        generateButtons.b1.setText(numbers.get(0));
        generateButtons.b2.setText(numbers.get(1));
        generateButtons.b3.setText(numbers.get(2));
        generateButtons.b4.setText(numbers.get(3));
        generateButtons.b5.setText(numbers.get(4));
        generateButtons.b6.setText(numbers.get(5));
        generateButtons.b7.setText(numbers.get(6));
        generateButtons.b8.setText(numbers.get(7));
        generateButtons.b9.setText(numbers.get(8));
        generateButtons.b10.setText(numbers.get(9));
        generateButtons.b11.setText(numbers.get(10));
        generateButtons.b12.setText(numbers.get(11));
        generateButtons.b13.setText(numbers.get(12));
        generateButtons.b14.setText(numbers.get(13));
        generateButtons.b15.setText(numbers.get(14));
        generateButtons.b16.setText(numbers.get(15));

    }

    @Override
    public void run() {
        // 時間の更新間隔を設定（10ミリ秒）
        int period = 10;

        while (!this.timePhase) {
            try {
                Thread.sleep((period));

            } catch (InterruptedException e) {
                e.printStackTrace();
                this.timePhase = true;
            }
            // UI スレッドで時間を更新します。この中で、現在の時間を計算してテキストビューに表示します。
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
            if (this.startPhase) {
                this.handleButtonClick(generateButtons.b1);
            }

        } else if (getID == R.id.button2) {
            if (this.startPhase) {
                this.handleButtonClick(generateButtons.b2);
            }

        } else if (getID == R.id.button3) {
            if (this.startPhase) {
                this.handleButtonClick(generateButtons.b3);
            }

        } else if (getID == R.id.button4) {
            if (this.startPhase) {
                this.handleButtonClick(generateButtons.b4);
            }

        } else if (getID == R.id.button5) {
            if (this.startPhase) {
                this.handleButtonClick(generateButtons.b5);
            }

        } else if (getID == R.id.button6) {
            if (this.startPhase) {
                this.handleButtonClick(generateButtons.b6);
            }

        } else if (getID == R.id.button7) {
            if (this.startPhase) {
                this.handleButtonClick(generateButtons.b7);
            }

        } else if (getID == R.id.button8) {
            if (this.startPhase) {
                this.handleButtonClick(generateButtons.b8);
            }

        } else if (getID == R.id.button9) {
            if (this.startPhase) {
                this.handleButtonClick(generateButtons.b9);
            }

        } else if (getID == R.id.button10) {
            if (this.startPhase) {
                this.handleButtonClick(generateButtons.b10);
            }

        } else if (getID == R.id.button11) {
            if (this.startPhase) {
                this.handleButtonClick(generateButtons.b11);
            }

        } else if (getID == R.id.button12) {
            if (this.startPhase) {
                this.handleButtonClick(generateButtons.b12);
            }

        } else if (getID == R.id.button13) {
            if (this.startPhase) {
                this.handleButtonClick(generateButtons.b13);
            }

        } else if (getID == R.id.button14) {
            if (this.startPhase) {
                this.handleButtonClick(generateButtons.b14);
            }

        } else if (getID == R.id.button15) {
            if (this.startPhase) {
                this.handleButtonClick(generateButtons.b15);
            }

        } else if (getID == R.id.button16) {
            if (this.startPhase) {
                this.handleButtonClick(generateButtons.b16);
            }

        } else if (getID == R.id.HomeButton) {
            Intent intentHome = new Intent(getApplication(), MainActivity.class);
            startActivity(intentHome);

        } else if (getID == R.id.RetryButton) {
            Intent intentRetry = new Intent(getApplication(), GameAction4.class);
            startActivity(intentRetry);

        } else if (getID == R.id.startButton) {
            commonButtons.startButton.setVisibility((View.INVISIBLE));
            this.startPhase = true;
            this.timePhase = false;
            thread = new Thread(this);
            thread.start();
            this.startTime = System.currentTimeMillis();

        } else if (getID == R.id.finishButton) {
            Intent intentFinish = new Intent(getApplication(), ScoreZone.class);
            intentFinish.putExtra("score_medium", textTime.getText().toString());
            startActivity(intentFinish);

        }
    }

    private void handleButtonClick(Button clickedButton) {
        if (clickedButton.getText().toString().equals("" + this.count)) {
            clickedButton.setVisibility(View.INVISIBLE);
            this.count += 1;
        }
        if (this.count == 17) {
            this.timePhase = true;
            textTime.setText(date.format(0));
            commonButtons.finishButton.setVisibility((View.VISIBLE));
            commonButtons.isHomeAvailable.setVisibility(View.INVISIBLE);
            commonButtons.isRetryAvailable.setVisibility(View.INVISIBLE);
        }
    }
}