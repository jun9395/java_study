package com.ssafy.activitycontroller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class InputFragment extends Fragment {

    Button btn;
    EditText edit1, edit2;

    public InputFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // 프래그먼트가 관리할 뷰를 생성
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        // 생성한 뷰 내부에 있는 뷰 객체의 주소값 추출
        btn = view.findViewById(R.id.button);
        edit1 = view.findViewById(R.id.editTextTextPersonName);
        edit2 = view.findViewById(R.id.editTextTextPersonName2);
        // 리스너 세팅
        btn.setOnClickListener(new BtnListener());
        return view;
    }


    // 버튼을 누르면 반응할 리스너
    class BtnListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // 현재 프래그먼트를 관리하는 Activity 객체 추출
            MainActivity activity = (MainActivity)getActivity();
            // 입력한 값을 activity 변수에 담는다
            activity.value1 = edit1.getText().toString();
            activity.value2 = edit2.getText().toString();
            // OutputFragment가 나타나도록 메서드 호출
            activity.setFragment("output");
        }
    }
}