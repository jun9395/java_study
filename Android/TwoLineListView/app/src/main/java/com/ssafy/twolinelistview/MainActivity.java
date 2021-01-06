package com.ssafy.twolinelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // 리스트 항목을 구성하기 위한 문자열 배열 2개
    String[] datas = {
            "list1", "list2", "list3", "list4", "list5", "list6"
    },
    datas2 = {
            "str1", "str2", "str3", "str4", "str5", "str6"
    };

    ListView list1;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = (ListView)findViewById(R.id.list1);
        text1 = (TextView)findViewById(R.id.textView);

        // 데이터를 담을 ArrayList
        ArrayList<HashMap<String, String>> data_list = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < datas.length; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("arr1", datas[i]);
            map.put("arr2", datas2[i]);

            data_list.add(map);
        }

        String[] keys = {"arr1", "arr2"};

        int[] ids = {android.R.id.text1, android.R.id.text2};

        SimpleAdapter adapter = new SimpleAdapter(this, data_list, android.R.layout.simple_list_item_2, keys, ids);
        list1.setAdapter(adapter);


        ListLitener listLitener = new ListLitener();
        list1.setOnItemClickListener(listLitener);
    }


    class ListLitener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            text1.setText(datas[position]);
        }
    }
}