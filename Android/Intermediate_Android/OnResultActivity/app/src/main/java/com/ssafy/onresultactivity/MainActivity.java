package com.ssafy.onresultactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text2 = findViewById(R.id.textView2);
    }


    public void MoveThirdMethod(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivityForResult(intent, 3);
    }


    public void MoveSecondMethod(View view) {
        // SecondActivity 실행을 요청
        Intent intent = new Intent(this, SecondActivity.class);
//        startActivity(intent);
        startActivityForResult(intent, 2);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2)
            text2.setText("Second 액티비티 실행 후 돌아옴");
        else {
            text2.setText("Third 액티비티 실행 후 돌아옴\n");
            switch (resultCode) {
                case RESULT_OK :
                    text2.append("OK");
                    break;
                case RESULT_CANCELED :  // RESULT를 세팅하지 않았다면 CANCELED가 들어온다
                    text2.append("CANCELED");
                    break;
                case RESULT_FIRST_USER :
                    text2.append("FIRST");
                    break;
                case RESULT_FIRST_USER + 1:
                    text2.append("FIRST + 1");
                    break;
            }
        }
    }
}