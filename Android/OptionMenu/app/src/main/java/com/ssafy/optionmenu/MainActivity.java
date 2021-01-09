package com.ssafy.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /*

        // xml을 통해 메뉴를 구성할 수 있는 객체를 호출
        MenuInflater inflater = getMenuInflater();

        // xml을 이용해 메뉴를 구성한다
        inflater.inflate(R.menu.option_menu, menu); // (경로, 메뉴 객체)

        */

        menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "코드메뉴 1");
        // menu.add(Menu.NONE, Menu.FIRST + 1, Menu.NONE, "코드메뉴 2");
        Menu sub = menu.addSubMenu("코드 메뉴2");
        sub.add(Menu.NONE, Menu.FIRST + 1 + 10, Menu.NONE, "코드 서브메뉴1");
        sub.add(Menu.NONE, Menu.FIRST + 2 + 10, Menu.NONE, "코드 서브메뉴2");

        menu.add(Menu.NONE, Menu.FIRST + 2, Menu.NONE, "코드메뉴 3");


        return true;
    }


    // 옵션 메뉴의 ㅎ아목을 터치하면 호출되는 메서드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // 사용자가 터치한 항목 개체의 id 추출
        int id = item.getItemId();

        /*
        switch (id) {
            case R.id.item1 :
                text1.setText("메뉴 1을 눌렀습니다");
                break;
            case R.id.item2_1 :
                text1.setText("서브메뉴 1을 눌렀습니다");
                break;
            case R.id.item2_2 :
                text1.setText("서브메뉴 2를 눌렀습니다");
                break;
            case R.id.item3 :
                text1.setText("메뉴 3을 눌렀습니다");
        }
        */

        switch (id) {
            case Menu.FIRST :
                text1.setText("코드메뉴 1을 눌렀습니다");
                break;
            case Menu.FIRST + 1 + 10 :
                text1.setText("코드 서브메뉴 1을 눌렀습니다");
                break;
            case Menu.FIRST + 2 + 10 :
                text1.setText("코드 서브메뉴 2를 눌렀습니다");
                break;
            case Menu.FIRST + 2 :
                text1.setText("코드메뉴 3을 눌렀습니다");
        }

        return super.onOptionsItemSelected(item);   // true, false 반환 차이는 OS에서나 확인 가능
    }
}