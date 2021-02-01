package com.ssafy.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;

    // 리스트뷰 구성
    ListView list1;
    String[] datas = {
            "항목1", "항목2", "항목3", "항목4", "항목5"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);

        // 뷰에 컨텍스트 메뉴를 설정한다
        registerForContextMenu(text1);


        // 리스트뷰 어댑터 연결
        list1 = (ListView)findViewById(R.id.list1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        list1.setAdapter(adapter);


        // 리스트뷰에 리스너 세팅
        ListListener listListener = new ListListener();
        list1.setOnItemClickListener(listListener);


        // 리스트뷰에 컨텍스트 메뉴를 설정
        registerForContextMenu(list1);
    }


    // 컨텍스트 메뉴가 설정되어 있는 뷰를 길게 누르면 컨텍스트 메뉴 구성을 위해서 호출하는 메서드
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // xml로 메뉴 구성
        MenuInflater inflater = getMenuInflater();


        // 사용자가 길게 누르면 뷰의 주소값을 얻어온다
        int view_id = v.getId();


        switch (view_id) {
            case R.id.textView :
                menu.setHeaderIcon(R.drawable.ic_launcher_foreground);  // 안드로이드 OS 버전에 따라서 나올 수도 아닐 수도 있음
                menu.setHeaderTitle("텍스튜 뷰의 컨텍스트 메뉴");
                inflater.inflate(R.menu.textview_menu, menu);
                break;

                // 리스트뷰의 컨텍스트 메뉴
            case R.id.list1 :
                // 사용자가 길게 누른 항목의 인덱스를 가져온다
                // menuInfo 객체를 형변환
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;

                menu.setHeaderTitle("컨텍스트 메뉴 : " + info.position);
                inflater.inflate(R.menu.listview_menu, menu);
                break;
        }
    }


    // 컨텍스트 메뉴의 항목을 터치하면 호출되는 메서드

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        // 컨텍스트메뉴는 여러 뷰에 세팅될 수 있으므로,
        // 텍스트뷰를 길게 눌러서 나온 컨텍스트 메뉴의 항목을 눌러서 호출됐는지,
        // 이미지뷰의 컨텍스트 메뉴의 항목을 눌러서 호출됐는지 여기서는 구분해야한다
        // 하지만 여기서 따로 구분할 방법은 없다
        // 그러므로 뷰가 다르다고 하더라도 컨텍스트 메뉴 항목의 아이디값을 전부 다르게 줘서
        // 메뉴 항목의 아이디로 구분을 해주자

        // 사용자가 선택한 메뉴 항목의 id를 추출
        int id = item.getItemId();


        // 사용자가 길게 누른 리스트 뷰의 항목 인덱스를 갖고 있는 객체를 추출
        ContextMenu.ContextMenuInfo info = item.getMenuInfo();

        int position = 0;
        // info가 null이 아니고, AdapterContextMenuInfo의 객체라면, 즉 onCreateContextMenu 때 리스트 뷰에 의해서 진행됐다면
        // getMenuInfo 메서드로 추출하면 ContextMenuInfo 타입으로 나오는데,
        // 부모클래스 info = 자식클래스 인 경우 info는 실질적으로 자식클래스이므로 판단이 가능하다
        if (info != null && info instanceof AdapterView.AdapterContextMenuInfo) {
            AdapterView.AdapterContextMenuInfo info2 = (AdapterView.AdapterContextMenuInfo)info;
            position = info2.position;
        }


        switch (id) {
            case R.id.text_item1 :
                text1.setText("텍스트뷰의 메뉴1을 선택했습니다");
                break;
            case R.id.text_item2 :
                text1.setText("텍스트뷰의 메뉴2를 선택했습니다");
                break;
                // 리스트뷰의 선택 메뉴
            case R.id.list_item1 :
                text1.setText("리스트뷰의 메뉴1을 선택했습니다 : " + position);
                break;
            case R.id.list_item2 :
                text1.setText("리스트뷰의 메뉴2를 선택했습니다 : " + position);
                break;
        }

        return super.onContextItemSelected(item);
    }


    // 리스트뷰의 리스너
    class ListListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            text1.setText("item click : " + datas[position]);
        }
    }
}