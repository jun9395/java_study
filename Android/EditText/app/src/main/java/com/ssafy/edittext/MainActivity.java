package com.ssafy.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editTextTextPersonName);
        text1 = (TextView)findViewById(R.id.textView);

        EnterListener enterListener = new EnterListener();
        editText.setOnEditorActionListener(enterListener);

        WatcherClass watcherClass = new WatcherClass();
        editText.addTextChangedListener(watcherClass);
    }


    public void btn1Method(View view) {
        editText.setText("새롭게 설정한 문자열");
    }


    public void btn2Method(View view) {
        String str = editText.getText().toString();
            // Editable이라는 문자열 클래스는 문자열 생성 때마다 계속 새로운 객체를 생성하지 않는다
            // 즉 현재 갖고 있는 문자열을 조절할 뿐이므로 메모리 적으로 이득
            // string형태로 받기
        text1.setText("입력한 문자열 : " + str);
    }


    class EnterListener implements TextView.OnEditorActionListener {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            String str = v.getText().toString();

            text1.setText("입력한 문자열 : " + str);
            return false;
        }
    }


    class WatcherClass implements TextWatcher {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            text1.setText("문자열 변경 중 " + s);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}