package com.ssafy.stylenotification;

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


    public void bigPictureMethod(View view) {
        // 접혀져있을 때와 펼쳐졌을 때를 정의하면 된다
        // 기본이 접혀져있을 때고, 펼쳐졌을 때를 추가로 넣으면 된다
        NotificationCompat.Builder builder = getNotification("style", "style Notification");
        builder.setContentTitle("Big Picture");
        builder.setContentText("Big Picture Notification");
        builder.setSmallIcon(android.R.drawable.ic_menu_agenda);


        // 펼쳐졌을 때
        // BigPicture Notification 객체 생성
        NotificationCompat.BigPictureStyle big = new NotificationCompat.BigPictureStyle(builder);

        // 보여줄 이미지 설정
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_android);
        big.bigPicture(bitmap);
        big.setBigContentTitle("Big Content Title");
        big.setSummaryText("Summary Test");


        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(10, notification);
    }


    public void bigTextMethod(View view) {
        NotificationCompat.Builder builder = getNotification("style", "style Notification");
        builder.setContentTitle("Big Text");
        builder.setContentText("Big Text Notification");
        builder.setSmallIcon(android.R.drawable.ic_menu_call);


        // 펼쳐졌을 때
        // BigText Style 객체 생성
        NotificationCompat.BigTextStyle big = new NotificationCompat.BigTextStyle(builder);
        big.setSummaryText("Summary Text");
        big.setBigContentTitle("Big Content Title");
        big.bigText("누구보다 빠르게 난 남들과는 다르게 색다르게 리듬타는 비트 위의 나그네");

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(11, notification);
    }


    public void inBoxMethod(View view) {
        NotificationCompat.Builder builder = getNotification("style", "style Notification");
        builder.setContentTitle("Content Title");
        builder.setContentText("Content Text");
        builder.setSmallIcon(android.R.drawable.ic_menu_day);


        // InboxStyle 객체를 생성
        NotificationCompat.InboxStyle inbox = new NotificationCompat.InboxStyle(builder);
        inbox.setSummaryText("Summary Text");

        // 표시할 문자열들을 세팅
        inbox.addLine("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
        inbox.addLine("01234567890123456789012345678901234567890123456789012345678901234567890123456789");
        inbox.addLine("가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하");
        inbox.addLine("아야어여오요우유으이아야어여오요우유으이아야어여오요우유으이아야어여오요우유으이");

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(12, notification);
    }


    public NotificationCompat.Builder getNotification(String id, String name) {
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