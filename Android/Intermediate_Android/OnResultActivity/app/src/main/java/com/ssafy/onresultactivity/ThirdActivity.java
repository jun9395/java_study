package com.ssafy.onresultactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }


    public void CloseThirdMethod(View view) {
        // 실행 결과를 세팅한다
        setResult(RESULT_OK);   // 정수값 넣어도 된다
        finish();
    }


    public void CancelMethod(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }


    public void FirstMethod(View view) {
        setResult(RESULT_FIRST_USER);
        finish();
    }


    public void First2Method(View view) {
        setResult(RESULT_FIRST_USER + 1);
        finish();
    }
}