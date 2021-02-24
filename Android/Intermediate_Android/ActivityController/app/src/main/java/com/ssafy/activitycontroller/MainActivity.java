package com.ssafy.activitycontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    // 관리할 프래그먼트 객체
    InputFragment inputFragment = new InputFragment();
    OutputFragment outputFragment = new OutputFragment();

    // 프래그먼트들이 공유할 변수
    String value1, value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // InputFragment 배치
        setFragment("input");
    }


    // 보여줄 프래그먼트를 관리하는 메서드
    public void setFragment(String name) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();

        // 프래그먼트 이름으로 분기
        switch (name) {
            case "input":
                tran.replace(R.id.container, inputFragment);
                break;
            case "output":
                tran.replace(R.id.container, outputFragment);
                tran.addToBackStack(null);
                break;
        }
        tran.commit();
    }
}