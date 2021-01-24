package com.ssafy.verhoriscreenchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;
    EditText editText;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        showToast("onCreate 호출됨");

        editText = findViewById(R.id.editText);
        text = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 버틀을 클릭했을 때 사용자가 입력한 값을 name 변수에 할당
                name = editText.getText().toString();
                showToast("입력된 값을 변수에 저장했습니다 : " + name);
                editText.setText("");
            }
        });

        // 이 화면이 초기화될 때 name 변수의 값 복원
        if (savedInstanceState != null) {
            name = savedInstanceState.getString("name");
            showToast("값을 복원했습니다 : " + name);

            text.setText(name);
        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // "name"이라는 이름으로 name 변수에 있는 값 저장
        outState.putString("name", name);
    }

    //    @Override
//    protected void onStart() {
//        super.onStart();
//
//        showToast("onStart 호출됨");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        showToast("onStop 호출됨");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        showToast("onDestroy 호출됨");
//    }


    public void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}