package com.ks_pem02.pem_shopping_list;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by katrinschauer on 27.10.15.
 */
public class CancelDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_cancel)
                .setPositiveButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dismiss();
                    }
                })
                .setNegativeButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        GroceriesFragment groceriesFrag = new GroceriesFragment();
                        getFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, groceriesFrag).commit();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
