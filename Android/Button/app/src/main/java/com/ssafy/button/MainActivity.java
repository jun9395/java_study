package com.ssafy.button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 뷰의 주소값을 담을 참조 변수
    TextView text1;
    Button button1, button2;
    Button button3, button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 뷰의 주소값을 얻어온다
        text1 = (TextView)findViewById(R.id.textView);
        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);

        // 리스너 객체
        BtnListener1 listener1 = new BtnListener1();
        BtnListener2 listener2 = new BtnListener2();

        // 리스너를 버튼 객체에 연결
        button1.setOnClickListener(listener1);  // button1을 onClick 하면 listener1이 작동한다
        button2.setOnClickListener(listener2);


        // 리스너 하나로 버튼 여러개 사용해보기
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        BtnListeners listeners = new BtnListeners();
        button3.setOnClickListener(listeners);
        button4.setOnClickListener(listeners);
    }


    // 첫 번째 버튼과 연결된 리스너
    class BtnListener1 implements View.OnClickListener {
        @Override
        public void onClick(View v) {   // 누른 객체의 주소값이 onClick( '여기에' ) 들어온다
            text1.setText("첫 번째 버튼을 눌렀습니다");
        }
    }

    // 두 번째 버튼과 연결된 리스너
    class BtnListener2 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            text1.setText("두 번째 버튼을 눌렀습니다");
        }
    }

    class BtnListeners implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.button3 :
                    text1.setText("세 번째 버튼을 눌렀습니다");
                    break;
                case R.id.button4 :
                    text1.setText("네 번째 버튼을 눌렀습니다");
            }
        }
    }


    // 다섯 번째 버튼을 누르면 호출되는 메서드
    public void btn56Method(View view) {
        switch (view.getId()) {
            case R.id.button5 :
                text1.setText("다섯 번째 버튼을 눌렀습니다");
                break;
            case R.id.button6 :
                text1.setText("여섯 번째 버튼을 눌렀습니다");
        }
    }

//     public void btn6Method(View view) {
//        text1.setText("여섯 번째 버튼을 눌렀습니다");
//     }
}