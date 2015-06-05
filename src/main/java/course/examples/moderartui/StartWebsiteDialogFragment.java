package course.examples.moderartui;

import android.app.DialogFragment;
import android.app.AlertDialog;
import android.os.Bundle;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

/**
 * Create dialog fragment for opening MOMA website
 */
public class StartWebsiteDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), AlertDialog.THEME_TRADITIONAL);
        builder.setMessage(R.string.dialog_message)
                .setPositiveButton(R.string.visit_moma, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        String URL = "http://www.moma.org";
                        //create Intent for opening website
                        Intent baseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                        // Start the Activity, using the base intent
                        startActivity(baseIntent);
                    }

                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // dismiss the dialog box
                        dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();

    }
}

