package com.example.tapgame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import utils.CreateArray;
import variablesDatas.CommonButtons;
import variablesDatas.CommonGameAction;
import variablesDatas.VariablesButtonsFour;

public class GameAction4 extends AppCompatActivity implements Runnable, View.OnClickListener {

    private VariablesButtonsFour generateButtons;
    private CommonButtons commonButtons;
    private final CommonGameAction commonGameAction = new CommonGameAction();

    /**
     * UIスレッドにメッセージを送信するためのHandler
     */
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_action4);

        CreateArray createNumberArray = new CreateArray();

        generateButtons = new VariablesButtonsFour(this);
        commonButtons = new CommonButtons(this);

        commonGameAction.startPhase = false;
        commonGameAction.count = 1;

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

        commonGameAction.textTime = findViewById(R.id.textTimeView);
        commonGameAction.textTime.setText(commonGameAction.date.format(0));

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

        // Runnableを定義し、時間の更新処理を行う
        Runnable updateTimeRunnable = new Runnable() {
            @Override
            public void run() {
                // UIスレッドで時間を更新します。この中で、現在の時間を計算してテキストビューに表示します。
                long endTime = System.currentTimeMillis();
                long nowTime = (endTime - commonGameAction.startTime);
                commonGameAction.textTime.setText(commonGameAction.date.format(nowTime));

                // commonGameAction.timePhaseがfalseの場合は、再度このRunnableを実行する
                if (!commonGameAction.timePhase) {
                    handler.postDelayed(this, period);
                }
            }
        };
        // 最初の実行
        handler.postDelayed(updateTimeRunnable, period);
    }

    @Override
    public void onClick(View view) {
        Thread thread;
        int getID = view.getId();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.button_scale);

        if (getID == R.id.button1) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b1, commonButtons, 17);
            }

        } else if (getID == R.id.button2) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b2, commonButtons, 17);
            }

        } else if (getID == R.id.button3) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b3, commonButtons, 17);
            }

        } else if (getID == R.id.button4) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b4, commonButtons, 17);
            }

        } else if (getID == R.id.button5) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b5, commonButtons, 17);
            }

        } else if (getID == R.id.button6) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b6, commonButtons, 17);
            }

        } else if (getID == R.id.button7) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b7, commonButtons, 17);
            }

        } else if (getID == R.id.button8) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b8, commonButtons, 17);
            }

        } else if (getID == R.id.button9) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b9, commonButtons, 17);
            }

        } else if (getID == R.id.button10) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b10, commonButtons, 17);
            }

        } else if (getID == R.id.button11) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b11, commonButtons, 17);
            }

        } else if (getID == R.id.button12) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b12, commonButtons, 17);
            }

        } else if (getID == R.id.button13) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b13, commonButtons, 17);
            }

        } else if (getID == R.id.button14) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b14, commonButtons, 17);
            }

        } else if (getID == R.id.button15) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b15, commonButtons, 17);
            }

        } else if (getID == R.id.button16) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b16, commonButtons, 17);
            }

        } else if (getID == R.id.HomeButton) {
            Intent intentHome = new Intent(getApplication(), MainActivity.class);
            startActivity(intentHome);

            commonButtons.isHomeAvailable.startAnimation(anim);

        } else if (getID == R.id.RetryButton) {
            Intent intentRetry = new Intent(getApplication(), GameAction4.class);
            startActivity(intentRetry);

            commonButtons.isRetryAvailable.startAnimation(anim);

        } else if (getID == R.id.startButton) {
            commonButtons.startButton.setVisibility((View.INVISIBLE));
            commonGameAction.startPhase = true;
            commonGameAction.timePhase = false;
            thread = new Thread(this);
            thread.start();
            commonGameAction.startTime = System.currentTimeMillis();

            commonButtons.startButton.startAnimation(anim);

        } else if (getID == R.id.finishButton) {
            Intent intentFinish = new Intent(getApplication(), ScoreZone.class);
            intentFinish.putExtra("score_medium", commonGameAction.textTime.getText().toString());
            startActivity(intentFinish);

            commonButtons.finishButton.startAnimation(anim);

        }
    }
}