package com.ssafy.ipc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 접속한 서비스 객체
    ServiceClass ipc_service = null;

    ConnectionsClass connection = new ConnectionsClass();

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Toast.makeText(this, text1.toString(), Toast.LENGTH_SHORT).show();

//        text1 = findViewById(R.id.myTextView);  // 텍스트 연결이 안 되네
        System.out.println("여기는 text1의 값을 추출합니다");
        System.out.println(text1);
//        Log.d("test", "text1 : " + text1.toString());

        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, ServiceClass.class);

        // 현재 서비스가 가동 중인지 확인
        boolean chk = isServiceRunning("com.ssafy.ipc.ServiceClass");

        if (!chk) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(intent);
            } else {
                startService(intent);
            }
        }

        // 서비스에 접속
        bindService(intent, connection, BIND_AUTO_CREATE);
    }


    public void getServiceNumber(View view) {
        // 서비스 객체의 메서드를 호출해 값을 반환
        int value = ipc_service.getNumber();
        Log.d("test", " 가져온 값 " + value);
        Toast.makeText(MainActivity.this, "value : " + value, Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }


    public boolean isServiceRunning(String name) {
        ActivityManager manager = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
        // 현재 실행 중인 서비스의 이름 가져옴
        List<ActivityManager.RunningServiceInfo> service_list =  manager.getRunningServices(Integer.MAX_VALUE);
        for (ActivityManager.RunningServiceInfo info : service_list) {
            if (info.service.getClassName().equals(name))
                return true;
        }
        return false;
    }


    // 서비스 접속 관리를 하는 클래스
    class ConnectionsClass implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // 전달받은 바인더 클래스를 이용해 서비스 객체를 추출
            ServiceClass.LocalBinder binder = (ServiceClass.LocalBinder)service;
            ipc_service = binder.getService();
        }


        @Override
        public void onServiceDisconnected(ComponentName name) {
            ipc_service = null;
        }
    }
}