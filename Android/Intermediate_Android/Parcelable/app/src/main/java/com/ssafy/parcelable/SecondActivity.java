package com.ssafy.parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView text1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secend);

        text1 = findViewById(R.id.textView);
        btn2 = findViewById(R.id.button2);

        // Intent 추출
        Intent intent = getIntent();

        // 객체 추출
        // 클래스의 CREATOR.createFromParcel 메서드를 호출해 반환받는 객체를 저장한다
        TestClass t1 = intent.getParcelableExtra("테스트1");

        text1.setText("t1.data10 : " + t1.data10 + "\n");
        text1.append("t1.data20 : " + t1.data20);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                TestClass t2 = new TestClass();
                t2.data10 = 20;
                t2.data20 = "문자열2";

                intent.putExtra("테스트2", t2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }


//    public void moveFirst(View view) {
//        Intent intent = new Intent();
//
//        TestClass t2 = new TestClass();
//        t2.data10 = 20;
//        t2.data20 = "문자열2";
//
//        intent.putExtra("테스트2", t2);
//        setResult(RESULT_OK, intent);
//        finish();
//    }
}