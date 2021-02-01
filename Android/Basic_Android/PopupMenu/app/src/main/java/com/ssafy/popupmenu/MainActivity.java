package com.ssafy.popupmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
        btn = (Button)findViewById(R.id.button);
    }


    public void btnMethod(View view) {
        // 팝업메뉴 객체를 생성
        PopupMenu pop = new PopupMenu(this, text1); // this, 어디에다 띄울지 주소

        // 팝업메뉴의 메뉴를 관리하는 객체 추출
        Menu menu = pop.getMenu();

        // 메뉴 인플레이터로 메뉴 구성
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.popup_menu, menu);  // 어느 xml로, 어디에


        // 팝업메뉴는 이 메서드가 호출될 때 생성되므로 여기서 리스너 설정
        PopupListener popupListener = new PopupListener();
        pop.setOnMenuItemClickListener(popupListener);


        // 메뉴를 나타나게 한다
        pop.show();
    }


    class PopupListener implements PopupMenu.OnMenuItemClickListener {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            // 사용자가 선택한 메뉴의 id값 추출
            int id = item.getItemId();

            switch (id) {
                case R.id.item1 :
                    text1.setText("메뉴1을 선택했습니다");
                    break;
                case R.id.item2 :
                    text1.setText("메뉴2를 선택했습니다");
                    break;
                case R.id.item3 :
                    text1.setText("메뉴3을 선택했습니다");
                    break;
            }

            return false;
        }
    }
}