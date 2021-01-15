package kr.co.softcampus.pendingintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Test1Activity extends AppCompatActivity {

    // 뷰의 주소 값을 담을 참조변수
    TextView text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        // 뷰의 주소 값을 받는다.
        text2 = (TextView)findViewById(R.id.textView2);
        // 액티비티를 실행할 때 사용한 인텐트 객체를 추출한다.
        Intent intent = getIntent();
        // 데이터를 추출한다.
        String data1 = intent.getStringExtra("data1");
        int data2 = intent.getIntExtra("data2", 0);

        text2.setText("data1 : " + data1 + "\n");
        text2.append("data2 : " + data2);
    }
}
