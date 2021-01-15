package kr.co.softcampus.button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 뷰의 주소 값을 담을 참조 변수
    TextView text1;
    Button button1, button2, button3, button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 뷰의 주소값을 얻어온다.
        text1 = (TextView)findViewById(R.id.textView);
        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        // 리스너 객체를 생성
        BtnListener1 listener1 = new BtnListener1();
        BtnListener2 listener2 = new BtnListener2();
        BtnListener34 listener34 = new BtnListener34();
        // 리스너를 버튼 객체에 설정한다.
        button1.setOnClickListener(listener1);
        button2.setOnClickListener(listener2);
        button3.setOnClickListener(listener34);
        button4.setOnClickListener(listener34);
    }

    // 첫 번째 버튼과 연결된 리스너
    class BtnListener1 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            text1.setText("첫 번째 버튼을 눌렀습니다");
        }
    }
    // 두 번째 버튼과 연결된 리스너
    class BtnListener2 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            text1.setText("두 번째 버튼을 눌렀습니다");
        }
    }
    // 세 번째와 네 번째 버튼과 연결된 리스너
    class BtnListener34 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            // 이벤트가 발생된 뷰의 ID 값을 추출한다.
            int id = v.getId();
            // id로 분기한다.
            switch (id){
                case R.id.button3 :
                    text1.setText("세 번째 버튼을 눌렀습니다");
                    break;
                case R.id.button4 :
                    text1.setText("네 번째 버튼을 눌렀습니다");
                    break;
            }
        }
    }

    // 다섯 번째 버튼을 누르면 호출되는 메서드
    public void btn5Method(View view){
        text1.setText("다섯 번째 버튼을 눌렀습니다");
    }
    // 여섯 번째 버튼을 누르면 호출되는 메서드
    public void btn6Method(View view){
        text1.setText("여섯 번째 버튼을 눌렀습니다");
    }
    // 일곱 번째, 여덟 번째 버튼을 누르면 호출되는 메서드
    public void btn78Method(View view){
        // 아이디 값을 추출한다.
        int id = view.getId();
        // 아이디 값으로 분기한다.
        switch (id){
            case R.id.button7 :
                text1.setText("일곱 번째 버튼을 눌렀습니다");
                break;
            case R.id.button8 :
                text1.setText("여덟 번째 버튼을 눌렀습니다");
                break;
        }
    }
}











