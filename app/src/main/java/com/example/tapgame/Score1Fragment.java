package com.example.tapgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import dialogs.DeleteDataDialog;
import utils.CompareTime;
import utils.CreateArray;


public class Score1Fragment extends Fragment implements View.OnClickListener {

    public SharedPreferences pref;
    private String scoreEasy;
    private String score1;
    private String score2;
    private String score3;
    private TextView timeTitle;
    private TextView timeText1;
    private TextView timeText2;
    private TextView timeText3;
    private Button homeButton;
    private Button retryButton;
    private Button resetButton;
    private boolean showNewScoreText = false;
    private TextView newScoreText;
    private CompareTime compareTime = new CompareTime();
    private CreateArray createArray = new CreateArray();
    private DeleteDataDialog deleteDataDialog;

    /**
     * 全てのスコアと新しいスコアを配列にまとめたもの
     */
    private ArrayList<String> scoreArray;
    /**
     * 加工済みの配列
     */
    private ArrayList<String> formattedArray;

    private final SharedPreferences.OnSharedPreferenceChangeListener scoreListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if (key != null && key.equals("score1")) {
                score1 = sharedPreferences.getString("score1", "00:00:00");
                timeText1.setText(score1);
            } else if (key != null && key.equals("score2")) {
                score2 = sharedPreferences.getString("score2", "00:00:00");
                timeText2.setText(score2);
            } else if (key != null && key.equals("score3")) {
                score3 = sharedPreferences.getString("score3", "00:00:00");
                timeText3.setText(score3);
            }
        }
    };

    /**
     * Score1Fragmentとfragment_score1の紐付けを行っている
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score1, container, false);

        this.pref = requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        this.pref.registerOnSharedPreferenceChangeListener(this.scoreListener);

//        this.deleteDataDialog = new DeleteDataDialog(this::deleteRecords);

        Bundle bundle = getArguments();

        this.timeTitle = view.findViewById(R.id.timeTitle);
        this.homeButton = view.findViewById(R.id.HomeButton);
        this.retryButton = view.findViewById(R.id.RetryButton);
        this.resetButton = view.findViewById(R.id.ResetButton);
        this.timeText1 = view.findViewById((R.id.timeText1));
        this.timeText2 = view.findViewById((R.id.timeText2));
        this.timeText3 = view.findViewById((R.id.timeText3));
        this.newScoreText = view.findViewById(R.id.newScoreText);

        this.score1 = this.pref.getString("score1", "00:00:00");
        this.score2 = this.pref.getString("score2", "00:00:00");
        this.score3 = this.pref.getString("score3", "00:00:00");


        if (bundle != null) {
            this.scoreEasy = bundle.getString("score_easy");
            this.timeTitle.setText(this.scoreEasy);
        }

        this.homeButton.setOnClickListener(this);
        this.retryButton.setOnClickListener(this);
        this.resetButton.setOnClickListener(this);

        this.timeText1.setText(this.score1);
        this.timeText2.setText(this.score2);
        this.timeText3.setText(this.score3);

        this.scoreArray = this.createArray.createStringArray(this.scoreEasy, this.score1, this.score2, this.score3);

        this.formattedArray = this.compareTime.parseArrayTime(this.scoreArray);

        this.showNewScoreText = this.compareTime.isShowNewScoreText(this.formattedArray, this.scoreEasy);


        if (this.showNewScoreText) {
            this.newScoreText.setVisibility(View.VISIBLE);
        } else {
            this.newScoreText.setVisibility(View.INVISIBLE);
        }

        this.updateValue();

        return view;
    }

    private void updateValue() {
        SharedPreferences.Editor editor = this.pref.edit();
        editor.putString("score1", this.formattedArray.get(0));
        editor.putString("score2", this.formattedArray.get(1));
        editor.putString("score3", this.formattedArray.get(2));
        editor.apply();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.pref.unregisterOnSharedPreferenceChangeListener(this.scoreListener);
    }

    @Override
    public void onClick(View view) {
        int getID = view.getId();
        Animation anim = AnimationUtils.loadAnimation(requireContext(), R.anim.button_scale);

        if (getID == R.id.HomeButton) {
            Intent intentHome = new Intent(requireActivity(), MainActivity.class);
            startActivity(intentHome);

            homeButton.startAnimation(anim);

        } else if (getID == R.id.RetryButton) {
            Intent intentRetry = new Intent(requireActivity(), GameAction3.class);
            startActivity(intentRetry);

            retryButton.startAnimation(anim);

        } else if (getID == R.id.ResetButton) {
            this.deleteDataDialog = new DeleteDataDialog(() -> deleteRecords(view));
            deleteDataDialog.show(getParentFragmentManager(), "delete_dialog_tag");

            resetButton.startAnimation(anim);

        }

    }

    public void deleteRecords(View view) {
        int getID = view.getId();

        if (getID == R.id.ResetButton) {
            SharedPreferences.Editor editor = this.pref.edit();
            editor.remove("score1");
            editor.remove("score2");
            editor.remove("score3");
            editor.apply();
        }
    }
}