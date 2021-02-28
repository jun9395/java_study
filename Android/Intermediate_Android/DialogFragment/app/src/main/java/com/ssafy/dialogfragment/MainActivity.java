package com.ssafy.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView);
    }


    public void getMyDialog(View view) {
        // 다이얼로그로 띄울 프래그먼트 객체 생성
        SubFragment sub = new SubFragment();
        FragmentManager manager = getSupportFragmentManager();

        // 프래그먼트 다이얼로그를 띄운다
        sub.show(manager, "tag");
    }
}