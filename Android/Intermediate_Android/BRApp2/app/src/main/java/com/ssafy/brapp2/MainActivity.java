package com.ssafy.brapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


// BroadCastReceiver를 부르기 위한 어플
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void btnMethod(View view) {
        // 명시적 인텐트
//        Intent intent = new Intent();
        // 패키지 네임(애플리케이션의 이름), 패키지이름.리시버클래스이름
//        intent.setClassName("com.ssafy.brapp1",
//                "com.ssafy.brapp1.TestReceiver");

        // 암시적 인텐트
        Intent intent = new Intent("com.ssafy.testbr");

        sendBroadcast(intent);
    }
}