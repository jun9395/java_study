package com.ssafy.customlistview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // 리스트뷰 항목에 세팅할 데이터
    int[] imgRes = {
            R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3,
            R.drawable.imgflag4, R.drawable.imgflag5, R.drawable.imgflag6
    };

    String[] datas = {
            "토고", "프랑스", "스위스", "스페인", "일본", "독일", "대한민국"
    };

    String[] datas2 = {
            "togo", "france", "swiss", "spain", "japan", "german", "korea"
    };


    ListView list1;
    TextView text3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = (ListView)findViewById(R.id.list1);
        text3 = (TextView)findViewById(R.id.textView3);


        // 어댑터를 생성한다
        // 항목 하나를 구성하기 위한 데이터를 순서대로 해시맵에 담고, 그 해시맵을 Array에 append 해서
        // 이 Array를 어댑터에 세팅
        // 데이터를 갖고 있는 ArrayList 생성
        ArrayList<HashMap<String, Object>> data_list = new ArrayList<HashMap<String, Object>>();

        for (int i = 0; i < imgRes.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("flag", imgRes[i]);
            map.put("kor", datas[i]);
            map.put("eng", datas2[i]);

            data_list.add(map);
        }

        // 해시맵 객체에 데이터를 저장할 때 사용한 이름 배열
        String[] keys = {"flag", "kor", "eng"};

        // 데이터를 세팅할 뷰의 id
        int[] ids = {R.id.imageView, R.id.textView, R.id.textView2};

        // 어댑터를 만들어준다
        SimpleAdapter adapter = new SimpleAdapter(this, data_list, R.layout.row, keys, ids);
        list1.setAdapter(adapter);

        ListListener listListener = new ListListener();
        list1.setOnItemClickListener(listListener);
    }


    class ListListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            text3.setText(datas[position]);
        }
    }
}