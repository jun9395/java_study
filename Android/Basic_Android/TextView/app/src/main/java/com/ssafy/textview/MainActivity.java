package com.ssafy.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 뷰의 주소값을 담을 참조 변수를 선언
    TextView test1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     // xml 데이터를 분석해서 객체를 만드는 시점은 이 시점
            // 그러므로 뷰의 주소값은 이것 이후에 부르자
        test1 = (TextView)findViewById(R.id.text2); // 이러면 text2에 Text2의 주소값이 불러와진다

        // 새로운 문자열 설정
        test1.setText("새로운 문자열이다");
    }
}