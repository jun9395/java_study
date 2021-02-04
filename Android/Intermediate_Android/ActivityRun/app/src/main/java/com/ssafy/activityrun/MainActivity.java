package com.ssafy.activityrun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void MoveSecondMethod(View view) {
        // Intent 객체를 만들어 실행한 액티비티의 정보를 세팅
        // this -> 이 클래스와 같은 어플리케이션에 있는 Activity를 실행하겠다, 새롭게 실행할 액티비티
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}