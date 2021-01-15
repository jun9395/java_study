package com.ssafy.messagenotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Person;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void btnMethod(View view) {
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        NotificationChannel channel = new NotificationChannel("message", "Message Style", NotificationManager.IMPORTANCE_HIGH);
        channel.enableLights(true);
        channel.setLightColor(Color.RED);
        channel.enableVibration(true);

        manager.createNotificationChannel(channel);


        Notification.Builder builder = new Notification.Builder(this, "message");
        builder.setContentTitle("Message Style");
        builder.setContentText("Message Style Notification");
        builder.setSmallIcon(android.R.drawable.ic_menu_agenda);

        // 대화하는 사람의 정보를 갖고 객체를 만들어줘야 한다
        Person.Builder builder1 = new Person.Builder();
        Icon icon1 = Icon.createWithResource(this, android.R.drawable.ic_menu_call);    // 원래는 사진
        builder1.setIcon(icon1);
        builder1.setName("고길동");
        Person user1 = builder1.build();

        Person.Builder builder2 = new Person.Builder();
        Icon icon2 = Icon.createWithResource(this, android.R.drawable.ic_menu_camera);
        builder2.setIcon(icon2);
        builder2.setName("마이콜");
        Person user2 = builder2.build();


        // 메시지 스타일 객체
        Notification.MessagingStyle style = new Notification.MessagingStyle(user1); // 생성자에 유저 객체 2개 중 하나
            // 메시지 내용, 메시지 도착 시작, 메시지 보낸 사람 객체
        style.addMessage("첫 번째 메시지", System.currentTimeMillis(), user1);
        style.addMessage("두 번째 메시지", System.currentTimeMillis(), user2);
        style.addMessage("세 번째 메시지", System.currentTimeMillis(), user1);
        style.addMessage("네 번째 메시지", System.currentTimeMillis(), user2);

        builder.setStyle(style);

        Notification notification = builder.build();
        manager.notify(11, notification);
    }
}