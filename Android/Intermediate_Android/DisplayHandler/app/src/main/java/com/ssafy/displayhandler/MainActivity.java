package com.ssafy.displayhandler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;

    // 쓰레드의 오래 걸리는 작업을 종료하기 위한 변수
    boolean isRunning = false;

    // 일반 스레드에서 요청한 화면 처리용 핸들러
    DisplayHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView);
        text2 = findViewById(R.id.textView2);

        handler = new DisplayHandler();

        // 오랜 시간이 걸리는 작업 가정
//        while (true) {
//            SystemClock.sleep(100);
//            long now = System.currentTimeMillis();
//            text2.setText("오래 걸리는 작업 : " + now);
//        }

        isRunning = true;
        ThreadClass thread = new ThreadClass();
        thread.start();
    }


    public void timeNowMethod(View view) {
        long now = System.currentTimeMillis();
        text1.setText("현재 시간 : " + now);
    }


    class ThreadClass extends Thread {
        int a1 = 10, a2 = 20;

        @Override
        public void run() {
            while (isRunning) {
                SystemClock.sleep(100);
                long now = System.currentTimeMillis();
                Log.d("test", "오래 걸리는 작업 : " + now);

                // 안드로이드 누가 밑에서는 오류 걸리는 화면 작업
//                text2.setText("오래 걸리는 작업 : " + now);
                SystemClock.sleep(100);
                handler.sendEmptyMessage(0);    // 작업을 구분하는 코드 0
                SystemClock.sleep(100);
                handler.sendEmptyMessage(1);

                // 핸들러 요청을 할 때 화면 처리를 위한 데이터를 전달한다
                // 정수값 2개와 객체 1개를 넘길 수 있다
                SystemClock.sleep(100);
                Message msg = new Message();
                msg.what = 2;
                msg.arg1 = ++a1;
                msg.arg2 = ++a2;
                msg.obj = now;

                handler.sendMessage(msg);

                SystemClock.sleep(1000);
            }
        }
    }


    class DisplayHandler extends Handler {
        // 개발자가 발생한 스레드에서 화면에 관련된 처리를 하기 위해 작업을 요청하면
        // 자동으로 호출되는 메서드(메인 스레드)
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
//            long time = System.currentTimeMillis();
//            text2.setText("핸들러 : " + time);
            if (msg.what == 1) {
                text2.setText("핸들러 작업 1");
            } else if (msg.what == 0) {
                text2.setText("핸들러 작업 0");
            } else {
                text2.setText(msg.arg1 + ", " + msg.arg2 + ", " + msg.obj);
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        isRunning = false;
    }
}