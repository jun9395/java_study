package com.ssafy.customlistview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] datas = {
            "데이터1", "데이터2", "데이터3", "데이터4", "데이터5", "데이터6"
    };

    ListView list1;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = (ListView)findViewById(R.id.list1);
        text1 = (TextView)findViewById(R.id.textView2);


        // 어댑터 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row, R.id.textView, datas);

        // 어댑터를 리스트 뷰에 세팅
        list1.setAdapter(adapter);


        ListListener listListener = new ListListener();
        list1.setOnItemClickListener(listListener);
    }


    class ListListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            text1.setText(datas[position]);
        }
    }
}