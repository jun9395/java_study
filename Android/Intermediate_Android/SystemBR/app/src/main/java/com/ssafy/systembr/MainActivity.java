package com.ssafy.systembr;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] permissions = {
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.RECEIVE_SMS
    };

    SystemReceiver br;
    Toast t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermissions();
        // 안드로이드 8.0 이상이므로 암시적 인텐트 등록 -> 기본 메시지 리시버는 할 필요 없는듯
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            br = new SystemReceiver();
//            IntentFilter filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
//            t = Toast.makeText(this, filter.toString(), Toast.LENGTH_SHORT);
//            t.show();
//            registerReceiver(br, filter);
//        }
    }


    public void checkPermissions() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }

        for (String permission : permissions) {
            int chk = checkCallingOrSelfPermission(permission);
            if (chk == PackageManager.PERMISSION_DENIED) {
                requestPermissions(permissions, 0);
                break;
            }
        }
    }


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            if (br != null) {
//                unregisterReceiver(br);
//                br = null;
//            }
//        }
//    }
}