package com.ssafy.notificationbasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // Notification message 만들기
    public void makeNotification(View view) {
        NotificationCompat.Builder builder = getNotificationBuilder("channel1", "첫 번째 채널");

        // Ticker 메시지 설정
        // 안드로이드 상단에 시계나 배터리 표시되는 부분에 한줄 메시지를 보여줌
        // 단, 안드로이드 7 미만에서만 작동
        builder.setTicker("Ticker 메시지");

        // 작은 아이콘 설정
        builder.setSmallIcon(android.R.drawable.ic_menu_search);

        // 큰 아이콘 설정
        // 비트맵(이미지를 관리하는 목적으로 사용하는 객체)이라는 객체를 만들어서 설정
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                // getResource 메서드를 사용하면 코드를 사용해서 res에 있는 것들을 직접 접근 가능
        builder.setLargeIcon(bitmap);

        // 숫자 설정 - 확인할 게 몇 개 있는지
        builder.setNumber(10);

        // 타이틀 설정
        builder.setContentTitle("Content title");

        // 내용 설정
        builder.setContentText("Content Text");


        // 메시지 객체를 생성
        // notification builder는 notificiation 객체를 생성하기 위해서 필요한 정보를 세팅하는 객체
        Notification notification = builder.build();

        // 알림 메시지 관리 객체 추출
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        // 알림 메시지 출력
        // 이 때 id값을 설정해주게 되는데
        // 이를 같은 값으로 하면 전에 확인 안 한 메시지가 덮어씌워짐
        manager.notify(10, notification);
    }


    public void makeNotification2(View view) {
        NotificationCompat.Builder builder = getNotificationBuilder("channel1", "첫 번째 채널");

        builder.setTicker("Ticker 메시지");

        builder.setSmallIcon(android.R.drawable.ic_menu_search);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        builder.setLargeIcon(bitmap);


        builder.setNumber(10);
        builder.setContentTitle("Content title 2");
        builder.setContentText("Content Text 2");


        Notification notification = builder.build();

        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        manager.notify(11, notification);
    }


    // 채널 변경
    public void makeNotification3(View view) {
        NotificationCompat.Builder builder = getNotificationBuilder("channel2", "두 번째 채널");

        builder.setTicker("Ticker 메시지");

        builder.setSmallIcon(android.R.drawable.ic_menu_search);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        builder.setLargeIcon(bitmap);


        builder.setNumber(10);
        builder.setContentTitle("Content title 3");
        builder.setContentText("Content Text 3");


        Notification notification = builder.build();

        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        manager.notify(20, notification);
    }


    public void makeNotification4(View view) {
        NotificationCompat.Builder builder = getNotificationBuilder("channel2", "두 번째 채널");

        builder.setTicker("Ticker 메시지");

        builder.setSmallIcon(android.R.drawable.ic_menu_search);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        builder.setLargeIcon(bitmap);


        builder.setNumber(10);
        builder.setContentTitle("Content title 4");
        builder.setContentText("Content Text 4");


        Notification notification = builder.build();

        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        manager.notify(21, notification);
    }


    // 안드로이드 8.0 이상을 대응하기 위한 Notification.Builder 생성 메서드
    public NotificationCompat.Builder getNotificationBuilder(String id, String name) {
        NotificationCompat.Builder builder = null;

        // OS 버전 별로 분기
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {   // 안드로이드 8.0은 Oreo
            // 알림 메시지를 관리하는 객체 생성
            NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

            // 채널 객체를 생성
            NotificationChannel channel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH);


            // 메시지 출력시 단말기 LED를 사용할 것인지
            channel.enableLights(true);
            // LED 색상
            channel.setLightColor(Color.RED);

            // 진동 사용여부
            channel.enableVibration(true);


            // 알림 메시지를 관리하는 객체에 채널을 등록
            manager.createNotificationChannel(channel);

            // 메시지 생성을 위한 객체 생성
            builder = new NotificationCompat.Builder(this, id);
        } else {
            builder = new NotificationCompat.Builder(this);
        }

        return builder;
    }
}