package com.ssafy.checkrootself;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try
        {
            //관리자 권한 요청
            Runtime.getRuntime().exec("su");
            //루트
            Log.d("test", "루트 권한이 있습니다");
        }
        catch ( Exception ex)
        {
            //루트 아님
            Log.d("text", "루트 권한이 없습니다");
        }
    }
}