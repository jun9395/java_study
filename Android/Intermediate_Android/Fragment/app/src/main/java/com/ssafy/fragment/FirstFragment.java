package com.ssafy.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    public FirstFragment() {
        // Required empty public constructor
    }


    // 화면에 배치될 때 onCreateView가 호출됨
    // inflater를 통해서 View 객체를 만들어서 return
    // 이 프래그먼트가 관리하는 뷰를 어디에다가 배치해야 하는지 지정된 레이아웃의 id의 객체가 container로 들어옴
    // 즉 R.layout.fragment_first를 container에 배치하라
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
}