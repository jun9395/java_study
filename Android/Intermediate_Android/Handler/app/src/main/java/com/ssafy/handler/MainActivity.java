package com.ssafy.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;

    // 핸들러
    Handler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);


        handler = new Handler();
        // 핸들러를 통해 요청할 작업
        ThreadClass thread = new ThreadClass();
        // thread.start(); 하면 별도의 스레드로 작업 그래서 화면 작업 불가능
        // 핸들러를 통해 작업을 1회 요청한다
        // handler.post(thread);

        // 딜레이 타임 주면서 요청
        handler.postDelayed(thread, 100);
    }


    public void timeNowMethod(View view) {
        long now = System.currentTimeMillis();
        text1.setText("버튼 클릭 : " + now);
    }


    class ThreadClass extends Thread {
        @Override
        public void run() {
            long now = System.currentTimeMillis();
            text2.setText("현재 시간 : " + now);

            // 현재 작업을 다시 요청한다.
//            handler.post(this);
            handler.postDelayed(this, 100);
        }
    }
}