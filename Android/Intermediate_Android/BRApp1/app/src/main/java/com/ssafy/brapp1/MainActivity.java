package com.ssafy.brapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;


// 브로트캐스트리시버를 갖고 있는 어플
public class MainActivity extends AppCompatActivity {

    TestReceiver br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 안드로이드 8.0 이상이면 암시적 인텐트를 코드로 등록
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            br = new TestReceiver();
            // 브로드캐스트리시버의 이름
            IntentFilter filter = new IntentFilter("com.ssafy.testbr");
            registerReceiver(br, filter);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (br != null) {
                unregisterReceiver(br);
                br = null;
            }
        }
    }
}