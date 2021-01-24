package com.ssafy.samplecallintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        Button button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                // 컴포넌트 이름을 지정할 수 있는 객체 생성
                ComponentName name = new ComponentName("com.ssafy.samplecallintent",
                        "com.ssafy.samplecallintent.MenuActivitiy");
                intent.setComponent(name);
                startActivityForResult(intent, 101);
            }
        });
    }


    public void SendCallIntent(View view) {
        String data = editText.getText().toString();

        // 전화걸기 화면을 보여줄 인텐트 객체 생성
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));
        startActivity(intent);
    }
}