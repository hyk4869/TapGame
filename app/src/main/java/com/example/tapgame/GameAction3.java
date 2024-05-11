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
import variablesDatas.VariablesButtonsThree;

public class GameAction3 extends AppCompatActivity implements Runnable, View.OnClickListener {

    private VariablesButtonsThree generateButtons;
    private CommonButtons commonButtons;
    private final CommonGameAction commonGameAction = new CommonGameAction();
    /**
     * UIスレッドにメッセージを送信するためのHandler
     */
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_action3);
        CreateArray createNumberArray = new CreateArray();

        generateButtons = new VariablesButtonsThree(this);
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

        ArrayList<String> numbers = createNumberArray.createArray(9);

        generateButtons.b1.setText(numbers.get(0));
        generateButtons.b2.setText(numbers.get(1));
        generateButtons.b3.setText(numbers.get(2));
        generateButtons.b4.setText(numbers.get(3));
        generateButtons.b5.setText(numbers.get(4));
        generateButtons.b6.setText(numbers.get(5));
        generateButtons.b7.setText(numbers.get(6));
        generateButtons.b8.setText(numbers.get(7));
        generateButtons.b9.setText(numbers.get(8));
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
                commonGameAction.handleButtonClick(generateButtons.b1, commonButtons, 10);
            }

        } else if (getID == R.id.button2) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b2, commonButtons, 10);
            }

        } else if (getID == R.id.button3) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b3, commonButtons, 10);
            }

        } else if (getID == R.id.button4) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b4, commonButtons, 10);
            }

        } else if (getID == R.id.button5) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b5, commonButtons, 10);
            }

        } else if (getID == R.id.button6) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b6, commonButtons, 10);
            }

        } else if (getID == R.id.button7) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b7, commonButtons, 10);
            }

        } else if (getID == R.id.button8) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b8, commonButtons, 10);
            }

        } else if (getID == R.id.button9) {
            if (commonGameAction.startPhase) {
                commonGameAction.handleButtonClick(generateButtons.b9, commonButtons, 10);
            }

        } else if (getID == R.id.HomeButton) {
            Intent intentHome = new Intent(getApplication(), MainActivity.class);
            startActivity(intentHome);
            commonButtons.isHomeAvailable.startAnimation(anim);

        } else if (getID == R.id.RetryButton) {
            Intent intentRetry = new Intent(getApplication(), GameAction3.class);
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
            intentFinish.putExtra("score_easy", commonGameAction.textTime.getText().toString());
            startActivity(intentFinish);
            commonButtons.finishButton.startAnimation(anim);
        }

    }
}