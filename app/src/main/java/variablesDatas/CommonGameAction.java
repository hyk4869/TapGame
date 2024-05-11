package variablesDatas;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class CommonGameAction {
    /**
     * 始まったかどうかを判定するもの
     */
    public boolean startPhase;
    public int count;
    public TextView textTime;
    public long startTime;
    public SimpleDateFormat date = new SimpleDateFormat("mm:ss:SS", Locale.JAPAN);
    public volatile boolean timePhase = false;

    public void handleButtonClick(Button clickedButton, CommonButtons commonButtons, int countValue) {
        if (clickedButton.getText().toString().equals("" + this.count)) {
            clickedButton.setVisibility(View.INVISIBLE);
            this.count += 1;
        }
        if (this.count == countValue) {
            this.timePhase = true;
            textTime.setText(date.format(0));
            commonButtons.finishButton.setVisibility((View.VISIBLE));
            commonButtons.isHomeAvailable.setVisibility(View.INVISIBLE);
            commonButtons.isRetryAvailable.setVisibility(View.INVISIBLE);
        }
    }
}
