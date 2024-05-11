package variablesDatas;

import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CommonScoreFragments {
    public SharedPreferences pref;
    public String timeScore;
    public String score1;
    public String score2;
    public String score3;
    public TextView timeTitle;
    public TextView timeText1;
    public TextView timeText2;
    public TextView timeText3;
    public Button homeButton;
    public Button retryButton;
    public Button resetButton;
    public boolean showNewScoreText = false;
    public TextView newScoreText;
    /**
     * 全てのスコアと新しいスコアを配列にまとめたもの
     */
    public ArrayList<String> scoreArray;
    /**
     * 加工済みの配列
     */
    public ArrayList<String> formattedArray;

    /**
     * 値の更新を行う箇所
     */
    public void updateValue(String score1, String score2, String score3) {
        SharedPreferences.Editor editor = this.pref.edit();
        editor.putString(score1, this.formattedArray.get(0));
        editor.putString(score2, this.formattedArray.get(1));
        editor.putString(score3, this.formattedArray.get(2));
        editor.apply();
    }

    /**
     * 値の削除を行う箇所
     */
    public void deleteRecords(int getID, int ResetButton, String score1, String score2, String score3) {

        if (getID == ResetButton) {
            SharedPreferences.Editor editor = this.pref.edit();
            editor.remove(score1);
            editor.remove(score2);
            editor.remove(score3);
            editor.apply();
        }
    }
}
