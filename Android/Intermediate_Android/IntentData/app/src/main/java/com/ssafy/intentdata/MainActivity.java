package com.ssafy.intentdata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView);
    }


    public void MoveSecondMethod(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

        intent.putExtra("data1", 100);
        intent.putExtra("data2", 11.11);
        intent.putExtra("data3", true);
        intent.putExtra("data4", "문자열데이터");

        startActivityForResult(intent, 0);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            int value1 = data.getIntExtra("value1", 0);
            double value2 = data.getDoubleExtra("value2", 0.0);
            boolean value3 = data.getBooleanExtra("value3", false);
            String value4 = data.getStringExtra("value4");

            text1.setText("value1 : " + value1 + "\n");
            text1.append("value2 : " + value2 + "\n");
            text1.append("vaule3 : " + value3 + "\n");
            text1.append("value4 : " + value4);
        }
    }
}