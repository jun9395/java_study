package com.ssafy.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // 서비스 가동을 위해 사용한 인텐트 객체
    Intent service_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void actService1(View view) {
        service_intent = new Intent(this, Service1.class);
        startService(service_intent);
    }


    public void endService1(View view) {
        stopService(service_intent);
    }


    public void startIntentService(View view) {
        service_intent = new Intent(this, Service2.class);
        startService(service_intent);
    }


    public void startForeService(View view) {
        service_intent = new Intent(this, Service3.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(service_intent);
        } else {
            startService(service_intent);
        }
//        finish();
    }
}