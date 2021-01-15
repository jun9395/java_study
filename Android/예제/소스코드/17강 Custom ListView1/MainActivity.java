package kr.co.softcampus.customlistview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 리스트 뷰를 구성하기 위한 문자열 배열
    String [] data = {
            "데이터1", "데이터2", "데이터3", "데이터4", "데이터5", "데이터6"
    };
    // 뷰의 주소 값을 담을 참조 변수
    ListView list1;
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 뷰의 주소 값을 받아온다.
        list1 = (ListView)findViewById(R.id.list1);
        text2 = (TextView)findViewById(R.id.textView2);
        // 어뎁터를 생성한다.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row, R.id.textView, data);
        // 어뎁터를 리스트 뷰에 셋팅한다.
        list1.setAdapter(adapter);

        // 리스너 셋팅
        ListListener listener = new ListListener();
        list1.setOnItemClickListener(listener);
    }
    // 리스트뷰의 리스너
    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            text2.setText(data[position]);
        }
    }
}








