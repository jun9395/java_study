package com.ssafy.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class Service1 extends Service {
    public Service1() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    // 서비스가 가동될 때 호출되는 메서드
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("test", "서비스 가동");

        // 쓰레드 가동
        ThreadClass threadClass = new ThreadClass();
        threadClass.start();

        return super.onStartCommand(intent, flags, startId);
    }


    // 서비스가 중지되면 호출되는 메서드
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("test", "서비스 중지");
    }


    class ThreadClass extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                SystemClock.sleep(1000);
                long time = System.currentTimeMillis();
                Log.d("test", "Service Running... " + time);
            }
        }
    }
}