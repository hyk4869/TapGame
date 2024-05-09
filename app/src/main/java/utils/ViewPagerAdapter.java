package utils;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tapgame.R;
import com.example.tapgame.Score1Fragment;
import com.example.tapgame.Score2Fragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {
    // 各タブの名前
    private List<Integer> titleIds = new ArrayList<>();
    // 各タブの画面
    private List<Fragment> fragments = new ArrayList<>();
    private Score1Fragment score1Fragment;
    private Score2Fragment score2Fragment;
    private Bundle bundle;

    public ViewPagerAdapter(FragmentActivity fragmentActivity, String score, String param) {
        super(fragmentActivity);
        this.titleIds.add(R.string.tab_title_1);
        this.titleIds.add(R.string.tab_title_2);

        this.score1Fragment = new Score1Fragment();
        this.score2Fragment = new Score2Fragment();

        this.bundle = new Bundle();

        this.bundle.putString("score_easy", param.equals("score_easy") ? score : null);
        this.score1Fragment.setArguments(this.bundle);
        this.fragments.add(this.score1Fragment);

        this.bundle.putString("score_medium", param.equals("score_medium") ? score : null);
        this.score2Fragment.setArguments(this.bundle);
        this.fragments.add(this.score2Fragment);

    }

    @Override
    public int getItemCount() {
        return this.fragments.size();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return this.fragments.get(position);
    }

    public int getTitleId(int position) {
        return this.titleIds.get(position);
    }

}

