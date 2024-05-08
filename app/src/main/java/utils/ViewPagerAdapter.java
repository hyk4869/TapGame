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

    public ViewPagerAdapter(FragmentActivity fragmentActivity, String score) {
        super(fragmentActivity);
        titleIds.add(R.string.tab_title_1);
        titleIds.add(R.string.tab_title_2);

        Score1Fragment score1Fragment = new Score1Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("score", score);
        score1Fragment.setArguments(bundle);
        fragments.add(score1Fragment);
//        fragments.add(new Score1Fragment());


        fragments.add(new Score2Fragment());
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    public int getTitleId(int position) {
        return titleIds.get(position);
    }

}

