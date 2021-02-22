package com.ssafy.activityaction;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // 승인받을 권한 목록
    String[] permission_list = {
            Manifest.permission.CALL_PHONE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermission();
    }


    public void moveGoogleMap(View view) {
        // 구글 지도를 통해 보여줄 위도와 경도 세팅
        Uri uri = Uri.parse("geo:37.243243, 131.861601");
        // 뭔가를 보여주는 목적으로 하는 액티비티를 실행해주는 ACTION_VIEW
        // uri에 들어간 schema가 뭐냐에 따라서 실행되는 액티비티가 달라진다
        // geo라면 좌표를 뜻하므로 지도가 실행되게 된다
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        startActivity(intent);
    }


    public void moveCrome(View view) {
        // 브라우저를 통해 보여줄 페이지의 주소를 세팅
        Uri uri = Uri.parse("http://m.naver.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    public void movePhone(View view) {
        // 전화번호를 세팅한다
        Uri uri = Uri.parse("tel: 010-1234-5678");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }


    // 전화 권한 받기
    public void checkPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }

        for (String permission : permission_list) {
            int chk = checkCallingOrSelfPermission(permission);
            if (chk == PackageManager.PERMISSION_DENIED) {
                requestPermissions(permission_list, 0);
                break;
            }
        }
    }


    // 전화 바로 걸기
    public void directCalling(View view) {
        // 권한 확인 여부를 체크한다
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int chk = checkCallingOrSelfPermission(Manifest.permission.CALL_PHONE);
            if (chk == PackageManager.PERMISSION_DENIED) {
                return;
            }
        }

        Uri uri = Uri.parse("tel: 010-1234-5678");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        startActivity(intent);
    }
}