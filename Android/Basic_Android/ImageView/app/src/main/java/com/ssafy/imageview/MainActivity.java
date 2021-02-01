package com.ssafy.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img4 = (ImageView)findViewById(R.id.imageView4);

        // 이미지를 세팅
        img4.setImageResource(R.drawable.cromeimage);
    }
}