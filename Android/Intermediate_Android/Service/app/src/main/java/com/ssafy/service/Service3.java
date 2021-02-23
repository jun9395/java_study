package com.ssafy.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class Service3 extends Service {
    public Service3() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // 안드로이드 8.0 이상이면 노티피케이션 메시지를 띄우고 포그라운드 서비스로 운영
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            // 8.0부터는 채널 등록을 해줘야 한다
            NotificationChannel channel = new NotificationChannel("test1", "Service", NotificationManager.IMPORTANCE_HIGH);

            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            manager.createNotificationChannel(channel);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "test1");
            builder.setSmallIcon(android.R.drawable.ic_menu_search);
            builder.setContentTitle("서비스 가동");
            builder.setContentText("서비스가 가동 중입니다");
            builder.setAutoCancel(true);
            Notification notification = builder.build();

            // 현재 노티피케이션 메시지를 포그라운드 서비스의 메시지로 등록
            startForeground(10, notification);
        }
        // 쓰레드 가동
        ThreadClass threadClass = new ThreadClass();
        threadClass.start();


        return super.onStartCommand(intent, flags, startId);
    }


    class ThreadClass extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                SystemClock.sleep(1000);
                long time = System.currentTimeMillis();
                Log.d("test", "Foreground Service Running... : " + time);
            }

            // 작업이 완료되면 노티피케이션 메시지를 사라지게 한다
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                stopForeground(STOP_FOREGROUND_REMOVE);
                NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                manager.cancel(10);
            }
        }
    }
}