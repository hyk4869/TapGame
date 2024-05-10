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


public class Score2Fragment extends Fragment implements View.OnClickListener {

    public SharedPreferences pref;
    private String scoreMedium;
    private String score4;
    private String score5;
    private String score6;
    private TextView timeTitle2;
    private TextView timeText4;
    private TextView timeText5;
    private TextView timeText6;
    private Button homeButton2;
    private Button retryButton2;
    private Button resetButton2;
    private boolean showNewScoreText = false;
    private TextView newScoreText2;
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
            if (key != null && key.equals("score4")) {
                score4 = sharedPreferences.getString("score4", "00:00:00");
                timeText4.setText(score4);
            } else if (key != null && key.equals("score5")) {
                score5 = sharedPreferences.getString("score5", "00:00:00");
                timeText5.setText(score5);
            } else if (key != null && key.equals("score6")) {
                score6 = sharedPreferences.getString("score6", "00:00:00");
                timeText6.setText(score6);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score2, container, false);

        this.pref = requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        this.pref.registerOnSharedPreferenceChangeListener(this.scoreListener);

        Bundle bundle = getArguments();

        this.timeTitle2 = view.findViewById(R.id.timeTitle2);
        this.homeButton2 = view.findViewById(R.id.HomeButton2);
        this.retryButton2 = view.findViewById(R.id.RetryButton2);
        this.resetButton2 = view.findViewById(R.id.ResetButton2);
        this.timeText4 = view.findViewById((R.id.timeText4));
        this.timeText5 = view.findViewById((R.id.timeText5));
        this.timeText6 = view.findViewById((R.id.timeText6));
        this.newScoreText2 = view.findViewById(R.id.newScoreText2);

        this.score4 = this.pref.getString("score4", "00:00:00");
        this.score5 = this.pref.getString("score5", "00:00:00");
        this.score6 = this.pref.getString("score6", "00:00:00");

        if (bundle != null) {
            this.scoreMedium = bundle.getString("score_medium");
            this.timeTitle2.setText(this.scoreMedium);
        }

        this.homeButton2.setOnClickListener(this);
        this.retryButton2.setOnClickListener(this);
        this.resetButton2.setOnClickListener(this);

        this.timeText4.setText(this.score4);
        this.timeText5.setText(this.score5);
        this.timeText6.setText(this.score6);

        this.scoreArray = this.createArray.createStringArray(this.scoreMedium, this.score4, this.score5, this.score6);

        this.formattedArray = this.compareTime.parseArrayTime(this.scoreArray);

        this.showNewScoreText = this.compareTime.isShowNewScoreText(this.formattedArray, this.scoreMedium);

        if (this.showNewScoreText) {
            this.newScoreText2.setVisibility(View.VISIBLE);
        } else {
            this.newScoreText2.setVisibility(View.INVISIBLE);
        }

        this.updateValue();

        return view;

    }

    private void updateValue() {
        SharedPreferences.Editor editor = this.pref.edit();
        editor.putString("score4", this.formattedArray.get(0));
        editor.putString("score5", this.formattedArray.get(1));
        editor.putString("score6", this.formattedArray.get(2));
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

        if (getID == R.id.HomeButton2) {
            Intent intentHome = new Intent(requireActivity(), MainActivity.class);
            startActivity(intentHome);

            homeButton2.startAnimation(anim);

        } else if (getID == R.id.RetryButton2) {
            Intent intentRetry = new Intent(requireActivity(), GameAction4.class);
            startActivity(intentRetry);

            retryButton2.startAnimation(anim);

        } else if (getID == R.id.ResetButton2) {
            this.deleteDataDialog = new DeleteDataDialog(() -> deleteRecords(view));
            deleteDataDialog.show(getParentFragmentManager(), "delete_dialog_tag");

            resetButton2.startAnimation(anim);

        }

    }

    public void deleteRecords(View view) {
        int getID = view.getId();

        if (getID == R.id.ResetButton2) {
            SharedPreferences.Editor editor = this.pref.edit();
            editor.remove("score4");
            editor.remove("score5");
            editor.remove("score6");
            editor.apply();
        }
    }
}