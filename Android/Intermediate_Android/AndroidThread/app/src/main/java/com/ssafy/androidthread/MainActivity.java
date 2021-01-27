package com.ssafy.androidthread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;

    // 쓰데르 동작 여부를 컨트롤할 변수
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView);
        text2 = findViewById(R.id.textView2);

        // 100ms마다 현재 시간을 가져와서 출력한다
//        while (true) {
//            SystemClock.sleep(100);
//            long now = System.currentTimeMillis();
//
//            text2.setText("무한 루프 : " + now);
//        }

        // 오래 걸리는 작업 처리를 위해 쓰레드 발생
        isRunning = true;
        ThreadClass thread = new ThreadClass();
        thread.start();
    }


    public void pringCurrentTime(View view) {
        // 현재 시간을 ms로 가져온다
        long now = System.currentTimeMillis();

        text1.setText("버튼 클릭 : " + now);
    }


    // 쓰레드 클래스
    class ThreadClass extends Thread {
        @Override
        public void run() {
            while (isRunning) {
                SystemClock.sleep(100);
                long now = System.currentTimeMillis();
                Log.d("test", "쓰레드 : " + now);
                text2.setText("쓰레드 : " + now);  // 안드로이드 7 이하에서는 이 부분에서 오류 발생
            }
        }
    }


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        // 쓰레드 종료를 위해 false 값을 넣어준다
//        isRunning = false;
//    }


    @Override
    protected void onStop() {
        super.onStop();
        isRunning = false;
    }
}