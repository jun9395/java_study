package com.ssafy.orientation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edit1;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.editTextTextPersonName);
        text1 = findViewById(R.id.textView);

        // 맨 처음 생성 때만 savedInstanceState에 null이 들어온다
        if (savedInstanceState != null) {
            String str2 = savedInstanceState.getString("data1");
            text1.setText(str2);
        }
    }


    public void getAndSetText(View view) {
        String str1 = edit1.getText().toString();
        text1.setText(str1);
    }


    // 화면 회전이 발생하면 호출하는 메서드
    // outState라는 번들객체가 들어오는데, 이 번들객체에 값을 넣어두면 된다
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // 화면 복원에 필요한 데이터를 저장
        outState.putString("data1", text1.getText().toString());
    }
}