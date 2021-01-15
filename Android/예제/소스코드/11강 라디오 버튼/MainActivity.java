package kr.co.softcampus.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 뷰의 주소값을 담을 참조변수
    RadioButton radio3, radio4;
    RadioGroup group1, group2;
    TextView text1, text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 뷰의 주소 값을 얻어온다.
        radio3 = (RadioButton)findViewById(R.id.radioButton3);
        radio4 = (RadioButton)findViewById(R.id.radioButton4);
        group1 = (RadioGroup)findViewById(R.id.group1);
        group2 = (RadioGroup)findViewById(R.id.group2);
        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);

        // 라디오 그룹에 리스너를 설정한다.
        RadioListener listener = new RadioListener();
        group1.setOnCheckedChangeListener(listener);
        group2.setOnCheckedChangeListener(listener);
    }

    public void btn1Method(View view){
        radio3.setChecked(true);
        radio4.setChecked(true);
    }

    public void btn2Method(View view){
        // 각 라디오 그룹 내에서 선택되어 있는 라디오 버튼의 id값을 가져온다.
        int id1 = group1.getCheckedRadioButtonId();
        int id2 = group2.getCheckedRadioButtonId();

        switch (id1){
            case R.id.radioButton :
                text1.setText("라디오 버튼 1-1 이 선택되었습니다");
                break;
            case R.id.radioButton2 :
                text1.setText("라디오 버튼 1-2 가 선택되었습니다");
                break;
            case R.id.radioButton3 :
                text1.setText("라디오 버튼 1-3 이 선택되었습니다");
                break;
        }

        switch (id2){
            case R.id.radioButton4 :
                text2.setText("라디오 버튼 2-1이 선택되었습니다");
                break;
            case R.id.radioButton5 :
                text2.setText("라디오 버튼 2-2가 선택되었습니다");
                break;
            case R.id.radioButton6 :
                text2.setText("라디오 버튼 2-3이 선택되었습니다");
                break;
        }
    }

    class RadioListener implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            // 체크 상태가 변경된 라디오 그룹의 아이디를 추출한다.
            int id = group.getId();

            switch(id){
                case R.id.group1 :
                    switch(checkedId){
                        case R.id.radioButton :
                            text1.setText("라디오 버튼 이벤트 : 1-1");
                            break;
                        case R.id.radioButton2 :
                            text1.setText("라디오 버튼 이벤트 : 1-2");
                            break;
                        case R.id.radioButton3 :
                            text1.setText("라디오 버튼 이벤트 : 1-3");
                            break;
                    }
                    break;
                case R.id.group2 :
                    switch (checkedId){
                        case R.id.radioButton4 :
                            text1.setText("라디오 버튼 이벤트 : 2-1");
                            break;
                        case R.id.radioButton5 :
                            text1.setText("라디오 버튼 이벤트 : 2-2");
                            break;
                        case R.id.radioButton6 :
                            text1.setText("라디오 버튼 이벤트 : 2-3");
                            break;
                    }
                    break;
            }
        }
    }
}










