package com.ssafy.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void btn1Method(View view) {
        // 토스트 객체 생성
        Toast t1 = Toast.makeText(this, "토스트 메시지입니다", Toast.LENGTH_SHORT);

        // 토스트 메시지를 운영체제에게 요청
        t1.show();
    }


    public void btn2Method(View view) {
        // 토스트를 통해 보여줄 뷰 객체 생성
        LayoutInflater inflater = getLayoutInflater();
        View v1 = inflater.inflate(R.layout.custom_toast, null);

        // 뷰 객체가 갖고 있는 뷰 추출
        ImageView img = (ImageView)v1.findViewById(R.id.imageView);
        TextView text1 = (TextView)v1.findViewById(R.id.textView);


        img.setImageResource(R.drawable.img_android);
        text1.setText("커스텀 토스트");

        // 뷰의 배경을 토스트 전용 배경 이미지로 설정
        // 안드로이드에서 기본 제공하는 게 하나 있다
        v1.setBackgroundResource(android.R.drawable.toast_frame);
        text1.setTextColor(Color.BLUE);


        // 생성한 뷰를 토스트 객체에 설정
        Toast t2 = new Toast(this);

        // 토스트 객체에 보여줄 뷰 세팅
        t2.setView(v1);

        // 토스트 메시지의 위치 설정
        t2.setGravity(Gravity.CENTER, 0, 250);    // 메시지의 중앙을 화면의 중앙에 맞춘다


        // 토스트가 표시될 시간 설정
        t2.setDuration(Toast.LENGTH_SHORT);

        t2.show();
    }
}