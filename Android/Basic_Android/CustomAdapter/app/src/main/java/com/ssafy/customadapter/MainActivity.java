package com.ssafy.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] datas = {"데이터1", "데이터2", "데이터3", "데이터4", "데이터5", "데이터6", "데이터7"};

    TextView text2;
    ListView list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text2 = (TextView)findViewById(R.id.textView2);
        list1 = (ListView)findViewById(R.id.list1);


        // 어댑터를 세팅
        ListAdapter adapter = new ListAdapter();
        list1.setAdapter(adapter);
    }


    // 어댑터를 만들자
    class ListAdapter extends BaseAdapter {
        BtnListener listener = new BtnListener();


        @Override
        public int getCount() {     // 리스트 뷰의 항목 개수를 알려주는 함수
            return datas.length;
        }

        @Override
        public Object getItem(int position) {   // 자유롭게 return을 구성, position에는 항목의 index가 들어옴
            return null;
        }

        @Override
        public long getItemId(int position) {   // View의 Id를 반환하고자 할 때 return 값을 바꿔서 사용
            return 0;
        }

        @Override
        // getCount를 통해 return된 값만큼 호출함
        // 100개 있는데 10개만 보여주도록 한 경우, 11~100은 안 불러와진다
        // 스크롤하면 그때 11~부터 호출하면서 구성
        // 그러면서 보이던 뷰가 안보이게 되면 convertView로 들어감
        // 그래서 다시 스크롤을 올리면 convertView를 돌려서 보여주면 됨
        public View getView(int position, View convertView, ViewGroup parent) {
                            // 현재 몇 번째 항목를 구성, 재사용 가능한 뷰 객체, 리스트뷰의 주소값
            // 재사용 가능한 뷰가 없다면 뷰를 만들어준다
            if (convertView == null) {
                LayoutInflater inflater = getLayoutInflater();  // xml은 레이아웃 인플레이터를 통해 뷰를 만들 수 있다
                convertView = inflater.inflate(R.layout.row, null);
            }
            // 뷰를 구성
                // row.xml에 있는 아이디 사용
            TextView sub_text = (TextView)convertView.findViewById(R.id.textView);
                // convertView 객체는 row.xml을 가지고 만든 View
            sub_text.setText(datas[position]);

            Button sub_btn1 = (Button)convertView.findViewById(R.id.button);
            Button sub_btn2 = (Button)convertView.findViewById(R.id.button2);

            sub_btn1.setOnClickListener(listener);
            sub_btn2.setOnClickListener(listener);


            // 버튼에 인덱스 값을 저장한다
            sub_btn1.setTag(position);
            sub_btn2.setTag(position);


            // 뷰를 반환한다
            return convertView;
        }
    }


    // 항목에 배치된 버튼에 세팅할 리스너
    class BtnListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // 버튼의 아이디를 추출한다

            switch (v.getId()) {
                case R.id.button :
                    text2.setText("첫 번째 버튼을 눌렀습니다 : " + v.getTag());
                    break;
                case R.id.button2 :
                    text2.setText("두 번째 버튼을 눌렀습니다 : " + (Integer)v.getTag());   // 현재 v.getTag()는 int형이다
            }
        }
    }
}