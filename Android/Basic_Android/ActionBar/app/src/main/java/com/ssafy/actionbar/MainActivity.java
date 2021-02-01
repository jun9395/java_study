package com.ssafy.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);

    }


    // 옵션메뉴 구성을 위해 호출하는 메서드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // xml파일로 메뉴 구성
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        // 검색 뷰가 설정되어 있는 메뉴 항목 객체 추출
        MenuItem search_item = menu.findItem(R.id.item5);

        // 액션 뷰로 배치한 뷰를 추출
        SearchView searchView = (SearchView) search_item.getActionView();

        // 이제 메서드를 이용해서 필요한 작업 이용
        // 안내 문구 설정
        searchView.setQueryHint("검색어를 입력해주세요");


        // 서치뷰에 리스너 설정
        SearchViewListener listener = new SearchViewListener();
        searchView.setOnQueryTextListener(listener);

        return true;
    }


    // 서치뷰의 리스너
    class SearchViewListener implements SearchView.OnQueryTextListener {
        @Override
        // 서치 뷰의 문자열이 변경될 때마다 호출되는 메서드
        public boolean onQueryTextChange(String newText) {
            text1.setText(newText);
            return false;
        }


        @Override
        public boolean onQueryTextSubmit(String query) {
            text2.setText(query);
            return false;
        }
    }


    // 옵션메뉴의 항목을 선택하면 호출되는 메서드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1 :
                text1.setText("메뉴 1을 선택했습니다");
                break;
            case R.id.item2 :
                text1.setText("메뉴 2를 선택했습니다");
                break;
            case R.id.item3 :
                text1.setText("메뉴 3을 선택했습니다");
                break;
            case R.id.item4 :
                text1.setText("메뉴 4를 선택했습니다");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}