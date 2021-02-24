package com.ssafy.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // 프래그먼트 객체 생성
    FirstFragment first = new FirstFragment();
    SecondFragment second = new SecondFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void setMyFirstFragment(View view) {
        // 프래그먼트 관리 객체 추출
        FragmentManager manager = getSupportFragmentManager();
        // 프래그먼트 변경을 관리하는 객체 추출
        // 새 프래그먼트 추가 혹은 변경
        FragmentTransaction tran = manager.beginTransaction();

        // 프래그먼트를 추가
//        tran.add(R.id.containter, first);

        // 프래그먼트 교체
        tran.replace(R.id.containter, first);


        // 프래그먼트 변경사항을 백스택에 포함하기
        tran.addToBackStack(null);  // null 대신 이름값 넣어도 된다

        // 적용
        tran.commit();
    }


    public void setMySecondFragment(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
//        tran.add(R.id.containter, second);
        tran.replace(R.id.containter, second);
        tran.addToBackStack(null);
        tran.commit();
    }
}