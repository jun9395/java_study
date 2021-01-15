package kr.co.softcampus.stylenotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn1Method(View view){

        NotificationCompat.Builder builder = getNotificationBuilder("style", "style Notification");
        builder.setContentTitle("Big Picture");
        builder.setContentText("Big Picture Notification");
        builder.setSmallIcon(android.R.drawable.ic_menu_agenda);

        // BigPicture Notification 객체를 생성한다.
        NotificationCompat.BigPictureStyle big = new NotificationCompat.BigPictureStyle(builder);
        // 보여줄 이미지를 설정한다.
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_android);
        big.bigPicture(bitmap);
        big.setBigContentTitle("Big Content Title");
        big.setSummaryText("Summary Test");

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(10, notification);
    }

    public void btn2Method(View view){
        NotificationCompat.Builder builder = getNotificationBuilder("style", "style notification");
        builder.setContentTitle("Big Text");
        builder.setContentText("Big Text Notification");
        builder.setSmallIcon(android.R.drawable.ic_menu_call);

        // BigTextStyle 객체를 생성한다.
        NotificationCompat.BigTextStyle big = new NotificationCompat.BigTextStyle(builder);
        big.setSummaryText("Summary Text");
        big.setBigContentTitle("Big Content Title");
        big.bigText("동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세");

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(20, notification);
    }

    public void btn3Method(View view){
        NotificationCompat.Builder builder = getNotificationBuilder("style", "style Notification");
        builder.setContentTitle("Content Title");
        builder.setContentText("Content Text");
        builder.setSmallIcon(android.R.drawable.ic_menu_day);

        // InboxStyle 객체를 생성한다.
        NotificationCompat.InboxStyle inbox = new NotificationCompat.InboxStyle(builder);
        inbox.setSummaryText("Summary TexT");
        // 표시할 문자열들을 셋팅한다.
        inbox.addLine("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        inbox.addLine("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        inbox.addLine("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        inbox.addLine("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        inbox.addLine("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        inbox.addLine("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(30, notification);
    }

    public NotificationCompat.Builder getNotificationBuilder(String id, String name){

        NotificationCompat.Builder builder = null;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
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













