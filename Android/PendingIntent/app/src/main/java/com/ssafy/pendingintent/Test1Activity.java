package com.ssafy.pendingintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Test1Activity extends AppCompatActivity {

    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        text2 = (TextView)findViewById(R.id.textView2);

        // 액티비티를 실행할 때 사용한 인텐트 객체를 가져옴
        Intent intent = getIntent();

        // 데이터 가져옴
        String data1 = intent.getStringExtra("데이터이름1"); // 값이 없으면 null이 들어온다
        int data2 = intent.getIntExtra("데이터이름2", 0);    // 기본 자료형은 default 값을 줘야 한다

        text2.setText("data1 : " + data1 + "\n");
        text2.append("data2 : " + data2);
    }
}