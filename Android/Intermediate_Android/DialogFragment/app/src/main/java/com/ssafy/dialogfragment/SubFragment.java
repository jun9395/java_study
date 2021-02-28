package com.ssafy.dialogfragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SubFragment extends DialogFragment {

    public SubFragment() {
        // Required empty public constructor
    }

    // 여기서 반환하는 dialog 객체를 갖고 다이얼로그를 띄우게 된다
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        MainActivity activity = (MainActivity)getActivity();

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("타이틀입니다");
        builder.setMessage("메시지입니다");

        DialogListener listener = new DialogListener();

        builder.setPositiveButton("positive", listener);
        builder.setNeutralButton("neutral", listener);
        builder.setNegativeButton("negative", listener);

        AlertDialog alert = builder.create();

        return alert;
    }


    class DialogListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            MainActivity activity = (MainActivity)getActivity();

            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    activity.text1.setText("positive");
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    activity.text1.setText("neutral");
                    break;
                case  DialogInterface.BUTTON_NEGATIVE:
                    activity.text1.setText("negative");
                    break;
            }
        }
    }
}