package com.ssafy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        System.out.println("onCreate 메서드 호출");
        Log.d("test", "onCreate 호출");
    }


    @Override
    // onCreate 메서드 호출 이후에 자동으로 호출
    // 혹은 Activity가 정지 상태가 되었다가 활동 상태로 돌아올 때 호출
    protected void onStart() {
        super.onStart();

        Log.d("test", "onStart 호출");
    }


    @Override
    // onStart 메서드가 호출된 이후에 자동으로 호출
    // Activity가 일시정지 되었다가 다시 시작될 때 호출
        // 현재 어플창 위에 팝업창 등이 떴을 때 일시정지
    protected void onResume() {
        super.onResume();

        Log.d("test", "onResume 호출");
    }


    @Override
    // Activity가 정지 상태가 되었다가 활동 상태로 돌아갈 때 onStart 메서드보다 먼저 호출
    // Restart -> Start -> Resume
    protected void onRestart() {
        super.onRestart();

        Log.d("test", "onRestart 호출");
    }


    @Override
    // Activity가 일시정지 상태가 될 때 호출
    // 어떤 상황에서든 Activity가 화면에서 사라지면 반드시 실행됨
    // 화면 상에서 완전히 사라지거나(이후 정지가 됨) 현재 화면 위에 팝업 창 등이 보여질 때
    protected void onPause() {
        super.onPause();

        Log.d("test", "onPause 호출");
    }


    @Override
    // Activity가 화면에서 사라질 때 호출
    protected void onStop() {
        super.onStop();

        Log.d("test", "onStop 호출");
    }


    @Override
    // 현재 Activity 수행이 완전히 종료되어 메모리 상에서 제거될 때 호출
    // 현재 애플리케이션을 종료하거나 백그라운드의 애플리케이션을 강제종료 할 때
    protected void onDestroy() {
        super.onDestroy();

        Log.d("test", "onDestroy");
    }
}