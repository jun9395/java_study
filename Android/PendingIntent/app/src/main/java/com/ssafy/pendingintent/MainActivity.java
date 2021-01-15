package com.ssafy.pendingintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
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


    public void btn1Method(View view) {
        NotificationCompat.Builder builder = getNotificationBuilder("pending", "pending intent");

        builder.setContentTitle("notification 1");
        builder.setContentText("알림 메시지 1입니다");
        builder.setSmallIcon(android.R.drawable.ic_menu_camera);
        builder.setAutoCancel(true);    // 메시지 클릭하여 새 Activity로 이동 시 메시지를 자동으로 삭제


        // 메시지를 터치하면 실행된 Activity 정보를 관리할 객체 생성
        Intent intent1 = new Intent(this, Test1Activity.class); // 실행할 Activity의 class를 지정

        // 실행될 Activity에 전달할 데이터 세팅
        intent1.putExtra("데이터이름1", "문자열 데이터1");
        intent1.putExtra("데이터이름2", 10);


        // 추가 액션 설정
        Intent intent2 = new Intent(this, Test2Activity.class);
        PendingIntent pending2 = PendingIntent.getActivity(this, 11, intent2, PendingIntent.FLAG_UPDATE_CURRENT);

        // 액션 생성을 위한 빌더 객체 생성
        // 이게 버튼처럼 나타나므로 아이콘이랑 문자열 하나씩 배치 가능
        NotificationCompat.Action.Builder builder2 = new NotificationCompat.Action.Builder(android.R.drawable.ic_menu_compass, "액션제목 1", pending2);

        // 이를 통해서 액션 객체를 만든 다음에 이를 NotificationBuilder에 세팅하면 된다
        NotificationCompat.Action action2 = builder2.build();
        builder.addAction(action2);



        // Intent 객체를 관리할 PendingIntent 객체를 생성하여 세팅
        // this, requestCode, 인텐트, 메시지 중요도
        PendingIntent pending1 = PendingIntent.getActivity(this, 10, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pending1);


        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(10, notification);
    }


    public void btn2Method(View view) {
        NotificationCompat.Builder builder = getNotificationBuilder("pending", "pending intent");

        builder.setContentTitle("notification 2");
        builder.setContentText("알림 메시지 2입니다");
        builder.setSmallIcon(android.R.drawable.ic_menu_camera);
        builder.setAutoCancel(true);


        Intent intent2 = new Intent(this, Test2Activity.class);

        PendingIntent pending1 = PendingIntent.getActivity(this, 10, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pending1);


        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(11, notification);
    }


    public NotificationCompat.Builder getNotificationBuilder(String id, String name) {
        NotificationCompat.Builder builder = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel channel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH);

            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);

            manager.createNotificationChannel(channel);

            builder = new NotificationCompat.Builder(this, id);
        } else {
            builder = new NotificationCompat.Builder(this);
        }

        return builder;
    }
}