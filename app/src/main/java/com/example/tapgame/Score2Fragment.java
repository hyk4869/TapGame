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

import androidx.fragment.app.Fragment;

import dialogs.DeleteDataDialog;
import utils.CompareTime;
import utils.CreateArray;
import variablesDatas.CommonScoreFragments;


public class Score2Fragment extends Fragment implements View.OnClickListener {

    private final CompareTime compareTime = new CompareTime();
    private final CreateArray createArray = new CreateArray();
    private DeleteDataDialog deleteDataDialog;

    private final CommonScoreFragments commonScoreFragments = new CommonScoreFragments();


    private final SharedPreferences.OnSharedPreferenceChangeListener scoreListener = (sharedPreferences, key) -> {
        if (key != null && key.equals("score4")) {
            commonScoreFragments.score1 = sharedPreferences.getString("score4", "00:00:00");
            commonScoreFragments.timeText1.setText(commonScoreFragments.score1);
        } else if (key != null && key.equals("score5")) {
            commonScoreFragments.score2 = sharedPreferences.getString("score5", "00:00:00");
            commonScoreFragments.timeText2.setText(commonScoreFragments.score2);
        } else if (key != null && key.equals("score6")) {
            commonScoreFragments.score3 = sharedPreferences.getString("score6", "00:00:00");
            commonScoreFragments.timeText3.setText(commonScoreFragments.score3);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score2, container, false);

        commonScoreFragments.pref = requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        commonScoreFragments.pref.registerOnSharedPreferenceChangeListener(this.scoreListener);

        Bundle bundle = getArguments();

        commonScoreFragments.timeTitle = view.findViewById(R.id.timeTitle2);
        commonScoreFragments.homeButton = view.findViewById(R.id.HomeButton2);
        commonScoreFragments.retryButton = view.findViewById(R.id.RetryButton2);
        commonScoreFragments.resetButton = view.findViewById(R.id.ResetButton2);
        commonScoreFragments.timeText1 = view.findViewById((R.id.timeText4));
        commonScoreFragments.timeText2 = view.findViewById((R.id.timeText5));
        commonScoreFragments.timeText3 = view.findViewById((R.id.timeText6));
        commonScoreFragments.newScoreText = view.findViewById(R.id.newScoreText2);

        commonScoreFragments.score1 = commonScoreFragments.pref.getString("score4", "00:00:00");
        commonScoreFragments.score2 = commonScoreFragments.pref.getString("score5", "00:00:00");
        commonScoreFragments.score3 = commonScoreFragments.pref.getString("score6", "00:00:00");

        if (bundle != null) {
            commonScoreFragments.timeScore = bundle.getString("score_medium");
            commonScoreFragments.timeTitle.setText(commonScoreFragments.timeScore);
        }

        commonScoreFragments.homeButton.setOnClickListener(this);
        commonScoreFragments.retryButton.setOnClickListener(this);
        commonScoreFragments.resetButton.setOnClickListener(this);

        commonScoreFragments.timeText1.setText(commonScoreFragments.score1);
        commonScoreFragments.timeText2.setText(commonScoreFragments.score2);
        commonScoreFragments.timeText3.setText(commonScoreFragments.score3);

        commonScoreFragments.scoreArray = this.createArray.createStringArray(commonScoreFragments.timeScore,
                commonScoreFragments.score1, commonScoreFragments.score2, commonScoreFragments.score3);

        commonScoreFragments.formattedArray = this.compareTime.parseArrayTime(commonScoreFragments.scoreArray);

        commonScoreFragments.showNewScoreText =
                this.compareTime.isShowNewScoreText(commonScoreFragments.formattedArray,
                        commonScoreFragments.timeScore);

        if (commonScoreFragments.showNewScoreText) {
            commonScoreFragments.newScoreText.setVisibility(View.VISIBLE);
        } else {
            commonScoreFragments.newScoreText.setVisibility(View.INVISIBLE);
        }

        commonScoreFragments.updateValue("score4", "score5", "score6");

        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        commonScoreFragments.pref.unregisterOnSharedPreferenceChangeListener(this.scoreListener);
    }

    @Override
    public void onClick(View view) {
        int getID = view.getId();
        Animation anim = AnimationUtils.loadAnimation(requireContext(), R.anim.button_scale);

        if (getID == R.id.HomeButton2) {
            Intent intentHome = new Intent(requireActivity(), MainActivity.class);
            startActivity(intentHome);

            commonScoreFragments.homeButton.startAnimation(anim);

        } else if (getID == R.id.RetryButton2) {
            Intent intentRetry = new Intent(requireActivity(), GameAction4.class);
            startActivity(intentRetry);

            commonScoreFragments.retryButton.startAnimation(anim);

        } else if (getID == R.id.ResetButton2) {
            this.deleteDataDialog = new DeleteDataDialog(() -> commonScoreFragments.deleteRecords(getID,
                    R.id.ResetButton2, "score4", "score5", "score6"));
            deleteDataDialog.show(getParentFragmentManager(), "delete_dialog_tag");

            commonScoreFragments.resetButton.startAnimation(anim);

        }

    }
}