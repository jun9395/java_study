package com.ssafy.smallactivityonmainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // activity_menu의 안쪽 리니어 레이아웃을 가져오기
        container = findViewById(R.id.container);


        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getSystemService() 메서드를 통해 LayoutInflater 객체를 참조
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                // container라는 id의 레이아웃 객체에 sub1.xml 파일의 레이아웃을 설정하여
                // 부분 레이아웃 sub1을 객체화
                inflater.inflate(R.layout.sub1, container, true);
                // 객체화 됐으므로 내부의 뷰들에 접근 가능
                CheckBox checkBox = container.findViewById(R.id.checkBox);
                checkBox.setText("로딩되었어요");
            }
        });
    }
}