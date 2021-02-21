package com.ssafy.parcelable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text2;

    final int SECOND_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text2 = findViewById(R.id.textView2);
    }


    public void moveSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

        TestClass t1 = new TestClass();
        t1.data10 = 100;
        t1.data20 = "문자열 1";

        // 객체가 가지고 있는 writeToParcel 메서드를 호출하는 부분
        // Parcelable 인터페이스를 구현한 객체를 putExtra를 통해서 intent 객체에 저장하면
        // writeToParcel 메서드가 자동으로 호출된다
        intent.putExtra("테스트1", t1);

//        startActivity(intent);
        startActivityForResult(intent, SECOND_ACTIVITY);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SECOND_ACTIVITY) {
            if (resultCode == RESULT_OK) {
                TestClass t2 = data.getParcelableExtra("테스트2");

                text2.setText("t2.data10 : " + t2.data10 + "\n");
                text2.append("t2.data20 : " + t2.data20);
            }
        }
    }
}