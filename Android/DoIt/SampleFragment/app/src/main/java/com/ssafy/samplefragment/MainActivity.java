package com.ssafy.samplefragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MainFragment mainFragment;
    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 프래그먼트는 뷰가 아니므로 findFragmentById() 메서드를 이용해 찾는다
        mainFragment = (MainFragment)getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        // 메뉴 프래그먼트는 새로운 객체로 만들어 할당
        menuFragment = new MenuFragment();
    }


    public void onFragmentChanged(int index) {
        if (index == 0) {
            // replace() 메서드의 첫 번째 파라미터는 프래그먼트를 담고 있는 레이아웃의 id
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    menuFragment).commit();
        } else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    mainFragment).commit();
        }
    }
}