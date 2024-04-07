package utils;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class GenerateButton {
    private Button[] buttons;

    public GenerateButton(Context context, ViewGroup parentLayout, int numButtons) {
        buttons = new Button[numButtons];

        // Create buttons dynamically and add them to the parent layout
        for (int i = 0; i < numButtons; i++) {
            buttons[i] = new Button(context);
            buttons[i].setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            buttons[i].setText("Button " + (i + 1)); // Set button text as desired
            parentLayout.addView(buttons[i]); // Add button to parent layout
        }
    }

    public Button[] getButtons() {
        return buttons;
    }
}
