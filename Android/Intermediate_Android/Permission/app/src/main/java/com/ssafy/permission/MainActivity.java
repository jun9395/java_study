package com.ssafy.permission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1;

    // 체크할 권한 목록
    String[] permission_list = {
            Manifest.permission.INTERNET,   // 권한 허용할 필요 없는 부분이라 바로 넘어간다
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.SEND_SMS,
            Manifest.permission.RECEIVE_SMS
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView);

        checkPermission();
    }


    public void checkPermission() {
        // 현재 안드로이드 버전이 6.0 미만이면 메서드 종료
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return;

        // 각 권한의 허용 여부 확인
        for (String permission: permission_list) {
            // 권한 허용 여부를 확인
            int check = checkCallingOrSelfPermission(permission);

            // 거부 상태라고 한다면
            if (check == PackageManager.PERMISSION_DENIED) {
                // permission_list 배열 안에 있는 것 중에서 권한이 필요한 것만 뺀다
                requestPermissions(permission_list, 0);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        text1.setText("");

        // 사용자가 권한 허용 여부를 확인한다
        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_GRANTED)
                text1.append(permissions[i] + " : 허용\n");
            else
                text1.append(permissions[i] + " : 거부\n");
        }
    }
}