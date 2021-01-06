package com.ssafy.listviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    ListView list1;

    // 리스트뷰 구성을 위해 필요한 문자열 배열
    String[] datas = {
            "리스트1", "리스트2", "리스트3", "리스트4", "리스트5", "리스트6",
            "리스트7", "리스트8", "리스트9", "리스트10", "리스트11", "리스트12",
            "리스트13", "리스트14", "리스트15", "리스트16", "리스트17", "리스트18"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
        list1 = (ListView)findViewById(R.id.list1);

        // 몇 개의 항목을 보여줄 것인가? => 배열이나 리스트의 항목 개수
        // 각 항목에 어떤 데이터를 보여줄 것인가? => 배열이나 리스트에 들어있는 값
        // 각 항목은 어떤 모양으로 보여줄 것인가? => 레이아웃 지정으로 보여주기

        // 문자열만을 보여줄 때 예시
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
            // 첫 번째 매개변수로 액티비티 자체를 넣어줘야 한다
            // 안드로이드 OS에서 기본 제공하는 레이아웃을 사용할 때는 android.R.layout.레이아웃이름
                // simple_list_item_1 - id가 text1로 되어있는 TextView 하나가 들어있는 레이아웃
            // 데이터가 들어있는 list 또는 array


        // 리스트 뷰에 어댑터를 설정
        list1.setAdapter(adapter);


        // 리스너 객체 생성 및 설정
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