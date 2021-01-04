package com.ssafy.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    CheckBox checkBox1, checkBox2, checkBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
        checkBox1 = (CheckBox)findViewById(R.id.checkBox);
        checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox)findViewById(R.id.checkBox3);

        // 체크박스에 리스너를 설정한다
        CheckBoxListener listener = new CheckBoxListener();
        checkBox1.setOnCheckedChangeListener(listener);
        checkBox2.setOnCheckedChangeListener(listener);
        checkBox3.setOnCheckedChangeListener(listener);
    }

    public void btn1Method(View view) {
        text1.setText("");

        if (checkBox1.isChecked()) {
            text1.append("첫번째 체크박스가 체크되어 있습니다\n");
        }

        if (checkBox2.isChecked()) {
            text1.append("두번째 체크박스가 체크되어 있습니다\n");
        }

        if (checkBox3.isChecked()) {
            text1.append("세번째 체크박스가 체크되어 있습니다\n");
        }
    }


    public void allCheckTrue(View view) {
        checkBox1.setChecked(true);
        checkBox2.setChecked(true);
        checkBox3.setChecked(true);
    }


    public void allCheckFalse(View view) {
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
    }


    public void toggleAll(View view) {
        checkBox1.toggle();
        checkBox2.toggle();
        checkBox3.toggle();
    }


    // 체크박스의 체크 상태가 변경되면 반응하는 리스너

    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {  // 컴파운드꺼로 선택하자

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {    // 체크상태 주소값, 체크상태
            int id = buttonView.getId();

            switch (id) {
                case R.id.checkBox :
                    if (isChecked == true) {
                        text1.setText("첫 번째 체크 박스가 체크되었습니다");
                    } else {
                        text1.setText("첫 번째 체크 박스가 체크 해제되었습니다");
                    }
                    break;
                case R.id.checkBox2 :
                    if (isChecked == true) {
                        text1.setText("두 번째 체크 박스가 체크되었습니다");
                    } else {
                        text1.setText("두 번째 체크 박스가 체크 해제되었습니다");
                    }
                    break;
                case R.id.checkBox3 :
                    if (isChecked == true) {
                        text1.setText("세 번째 체크 박스가 체크되었습니다");
                    } else {
                        text1.setText("세 번째 체크 박스가 체크 해제되었습니다");
                    }
                    break;
            }
        }
    }
}