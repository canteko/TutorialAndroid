package com.canteko.helloworld;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class NuevaAveriaDialogo extends DialogFragment {

    AlertDialog.Builder builder;
    OnNuevaAveriaListener mListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        builder = new AlertDialog.Builder(getActivity());
        builder.setView(inflater.inflate(R.layout.dialog_averia, null));
        builder.setTitle("Jeje hola")
                .setPositiveButton("R.string.fire", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "" + id, Toast.LENGTH_LONG).show();
                        mListener.onAveriaGuardarListener();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("R.string.cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnNuevaAveriaListener) activity;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }
}
