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


public class Score1Fragment extends Fragment implements View.OnClickListener {

    private final CompareTime compareTime = new CompareTime();
    private final CreateArray createArray = new CreateArray();
    private DeleteDataDialog deleteDataDialog;
    private final CommonScoreFragments commonScoreFragments = new CommonScoreFragments();

    private final SharedPreferences.OnSharedPreferenceChangeListener scoreListener = (sharedPreferences, key) -> {
        if (key != null && key.equals("score1")) {
            commonScoreFragments.score1 = sharedPreferences.getString("score1", "00:00:00");
            commonScoreFragments.timeText1.setText(commonScoreFragments.score1);
        } else if (key != null && key.equals("score2")) {
            commonScoreFragments.score2 = sharedPreferences.getString("score2", "00:00:00");
            commonScoreFragments.timeText2.setText(commonScoreFragments.score2);
        } else if (key != null && key.equals("score3")) {
            commonScoreFragments.score3 = sharedPreferences.getString("score3", "00:00:00");
            commonScoreFragments.timeText3.setText(commonScoreFragments.score3);
        }
    };


    /**
     * Score1Fragmentとfragment_score1の紐付けを行っている
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score1, container, false);

        commonScoreFragments.pref = requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        commonScoreFragments.pref.registerOnSharedPreferenceChangeListener(this.scoreListener);

        Bundle bundle = getArguments();

        commonScoreFragments.timeTitle = view.findViewById(R.id.timeTitle);
        commonScoreFragments.homeButton = view.findViewById(R.id.HomeButton);
        commonScoreFragments.retryButton = view.findViewById(R.id.RetryButton);
        commonScoreFragments.resetButton = view.findViewById(R.id.ResetButton);
        commonScoreFragments.timeText1 = view.findViewById((R.id.timeText1));
        commonScoreFragments.timeText2 = view.findViewById((R.id.timeText2));
        commonScoreFragments.timeText3 = view.findViewById((R.id.timeText3));
        commonScoreFragments.newScoreText = view.findViewById(R.id.newScoreText);

        commonScoreFragments.score1 = commonScoreFragments.pref.getString("score1", "00:00:00");
        commonScoreFragments.score2 = commonScoreFragments.pref.getString("score2", "00:00:00");
        commonScoreFragments.score3 = commonScoreFragments.pref.getString("score3", "00:00:00");


        if (bundle != null) {
            commonScoreFragments.timeScore = bundle.getString("score_easy");
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

        commonScoreFragments.updateValue("score1", "score2", "score3");

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

        if (getID == R.id.HomeButton) {
            Intent intentHome = new Intent(requireActivity(), MainActivity.class);
            startActivity(intentHome);
            commonScoreFragments.homeButton.startAnimation(anim);

        } else if (getID == R.id.RetryButton) {
            Intent intentRetry = new Intent(requireActivity(), GameAction3.class);
            startActivity(intentRetry);
            commonScoreFragments.retryButton.startAnimation(anim);

        } else if (getID == R.id.ResetButton) {
            this.deleteDataDialog = new DeleteDataDialog(() -> commonScoreFragments.deleteRecords(getID,
                    R.id.ResetButton, "score1", "score2", "score3"));
            deleteDataDialog.show(getParentFragmentManager(), "delete_dialog_tag");
            commonScoreFragments.resetButton.startAnimation(anim);

        }
    }
}