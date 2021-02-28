package com.ssafy.listfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class SubFragment extends ListFragment {

    TextView text1;

    // 리스트뷰를 구성하기 위한 데이터
    String[] viewList = {"항목1", "항목2", "항목3", "항목4", "항목5"};

    public SubFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sub, container, false);

        // 뷰의 주소값으 얻어온다
        // 리스트 뷰의 주소값은 알아서 관리해준다
        text1 = view.findViewById(R.id.textView);

        // 리스트뷰에 적용ㅎ라 어탭터 생성
        MainActivity activity = (MainActivity)getActivity();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, viewList);

        // 어댑터를 리스트뷰에 적용
        setListAdapter(adapter);

        return view;
    }


    // 리스트뷰의 항목을 터치하면 호출되는 메서드

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        text1.setText("선택한 항목 : " + viewList[position]);
    }
}