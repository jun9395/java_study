package com.ssafy.activitycontroller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OutputFragment extends Fragment {

    Button btn2;
    TextView text1, text2;

    public OutputFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_output, container, false);

        btn2 = view.findViewById(R.id.button2);
        btn2.setOnClickListener(new BtnListener2());

        text1 = view.findViewById(R.id.textView);
        text2 = view.findViewById(R.id.textView2);

        // MainActivity 객체 추출
        MainActivity activity = (MainActivity)getActivity();
        text1.setText(activity.value1);
        text2.setText(activity.value2);

        return view;
    }


    class BtnListener2 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            MainActivity activity = (MainActivity)getActivity();

            FragmentManager manager = activity.getSupportFragmentManager();

            // 이전 프래그먼트로 이동동
           manager.popBackStack();
        }
    }
}