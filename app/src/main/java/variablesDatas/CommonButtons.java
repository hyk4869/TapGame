package variablesDatas;

import android.content.Context;
import android.widget.Button;

/**
 * 共通のボタン変数
 */
public class CommonButtons {
    public Button startButton;
    public Button finishButton;
    public Button isHomeAvailable;
    public Button isRetryAvailable;

    public CommonButtons(Context context) {
        startButton = new Button(context);
        finishButton = new Button(context);
        isHomeAvailable = new Button(context);
        isRetryAvailable = new Button(context);
    }
}

