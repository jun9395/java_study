package kr.co.softcampus.contextmenu;

import android.support.v7.app.AppCompatActivity;
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

    // 뷰의 주소 값을 담을 참조 변수
    TextView text1;
    ListView list1;
    // 리스트뷰를 구성하기 위한 문자열 배열
    String [] data1 = {
            "항목1", "항목2", "항목3", "항목4", "항목5"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 뷰의 주소 값을 받아온다.
        text1 = (TextView)findViewById(R.id.textView);
        list1 = (ListView)findViewById(R.id.list1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data1);
        list1.setAdapter(adapter);

        ListListener listener = new ListListener();
        list1.setOnItemClickListener(listener);

        // 뷰에 컨텍스트 메뉴를 설정한다.
        registerForContextMenu(text1);
        registerForContextMenu(list1);
    }
    // 컨텍스트 메뉴가 설정되어 있는 뷰를 길게 누르면 컨텍스트 메뉴 구성을 위해서 호출하는 메서드
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();

        // 사용가 길게 누르면 뷰의 주소 값을 얻어온다.
        int view_id = v.getId();

        switch (view_id){
            case R.id.textView :
                menu.setHeaderTitle("텍스트 뷰의 컨텍스트 메뉴");
                inflater.inflate(R.menu.textview_menu, menu);
                break;
            case R.id.list1 :
                // 사용자가 길게 누른 항목의 인덱스를 가져온다.
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;

                menu.setHeaderTitle("리스트 뷰의 메뉴 : " + info.position);
                inflater.inflate(R.menu.listview_menu, menu);
                break;
        }
    }

    // 컨텍스트 메뉴의 항목을 터치하면 호출되는 메서드
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        // 사용자가 선택한 메뉴 항목의 id를 추출한다.
        int id = item.getItemId();

        // 사용자가 길게 누른 리스트의 항목 인덱스를 가지고 있는 객체를 추출한다.
        ContextMenu.ContextMenuInfo info = item.getMenuInfo();
        int position = 0;
        if(info != null && info instanceof AdapterView.AdapterContextMenuInfo){
            AdapterView.AdapterContextMenuInfo info2 = (AdapterView.AdapterContextMenuInfo)info;
            position = info2.position;
        }

        switch (id){
            case R.id.text_item1 :
                text1.setText("텍스트뷰의 메뉴1을 선택하였습니다");
                break;
            case R.id.text_item2 :
                text1.setText("텍스트뷰의 메뉴2를 선택하였습니다");
                break;
            case R.id.list_item1 :
                text1.setText("리스트뷰의 메뉴1을 선택하였습니다 : " + position);
                break;
            case R.id.list_item2 :
                text1.setText("리스트뷰의 메뉴2를 선택하였습니다 : " + position);
                break;
        }

        return super.onContextItemSelected(item);
    }

    // 리스트뷰의 리스너
    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            text1.setText("item click : " + data1[position]);
        }
    }
}










