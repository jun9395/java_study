package com.ssafy.runonuithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;

    // 스레드 중지 처리를 위한 변수
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView);
        text2 = findViewById(R.id.textView2);

        // 스레드 가동
        isRunning = true;
        ThreadClass thread = new ThreadClass();
        thread.start();
    }


    public void timeNowMethod(View view) {
        long now = System.currentTimeMillis();
        text1.setText("버튼 클릭 : " + now);
    }


    class ThreadClass extends Thread {
        @Override
        public void run() {
            while (isRunning) {
                SystemClock.sleep(100);

                final long time = System.currentTimeMillis();   // final을 선언한 스레드 이외의 스레드에서 사용가능
                Log.d("test", "쓰레드 : " + time);

                // 일반 스레드에서 화면 처리가 필요한 경우
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        text2.setText("쓰레드 : " + time);
                    }
                });
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        isRunning = false;
    }
}