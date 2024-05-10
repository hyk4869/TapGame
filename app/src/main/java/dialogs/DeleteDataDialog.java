package dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DeleteDataDialog extends DialogFragment {
    private Runnable deleteMethod;

    // 処理はメソッドを受け取って、それを実行させる
    public DeleteDataDialog(Runnable deleteContent) {
        this.deleteMethod = deleteContent;
    }

    public void executeDelete() {
        if (deleteMethod != null) {
            deleteMethod.run();
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Delete Score")
                .setMessage("Are you sure to delete the data?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        executeDelete();
                    }
                }).setNegativeButton("no", null);
        return builder.create();
    }
}

