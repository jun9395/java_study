package com.ssafy.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    RadioGroup group1, group2;
    RadioButton radio3, radio4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);
        group1 = (RadioGroup)findViewById(R.id.radioGroup);
        group2 = (RadioGroup)findViewById(R.id.radioGroup2);
        radio3 = (RadioButton)findViewById(R.id.radioButton3);
        radio4 = (RadioButton)findViewById(R.id.radioButton4);


        RadioListener radioListener = new RadioListener();
        group1.setOnCheckedChangeListener(radioListener);
        group2.setOnCheckedChangeListener(radioListener);
    }


    public void btn1Method(View view) {
        radio3.setChecked(true);
        radio4.setChecked(true);
    }


    public void btn2Method(View view) {
        // 각 라디오 그룹 내에서 선택되어 있는 라디오 버튼의 id값을 가져온다
        int id1 = group1.getCheckedRadioButtonId();
        int id2 = group2.getCheckedRadioButtonId();

        switch (id1) {
            case R.id.radioButton :
                text1.setText("1 - 1 선택되었습니다");
                break;
            case R.id.radioButton2 :
                text1.setText("1 - 2 선택되었습니다");
                break;
            case R.id.radioButton3 :
                text1.setText("1 - 3 선택되었습니다");
        }

        switch (id2) {
            case R.id.radioButton4 :
                text2.setText("2 - 1 선택되었습니다");
                break;
            case R.id.radioButton5 :
                text2.setText("2 - 2 선택되었습니다");
                break;
            case R.id.radioButton6 :
                text2.setText("2 - 3 선택되었습니다");
        }
    }


    class RadioListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (group.getId() == R.id.radioGroup) {
                switch (checkedId) {
                    case R.id.radioButton :
                        text1.setText("라디오 버튼 이벤트 1-1");
                        break;
                    case R.id.radioButton2 :
                        text1.setText("라디오 버튼 이벤트 1-2");
                        break;
                    case R.id.radioButton3 :
                        text1.setText("라디오 버튼 이벤트 1-3");
                        break;
                }
            } else {
                switch (checkedId) {
                    case R.id.radioButton4 :
                        text2.setText("라디오 버튼 이벤트 2-1");
                        break;
                    case R.id.radioButton5 :
                        text2.setText("라디오 버튼 이벤트 2-2");
                        break;
                    case R.id.radioButton6 :
                        text2.setText("라디오 버튼 이벤트 2-3");
                        break;
                }
            }
        }
    }
}