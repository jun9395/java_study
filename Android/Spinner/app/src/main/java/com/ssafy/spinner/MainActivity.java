package com.ssafy.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 스피너 구성을 위한 문자열 배열
    String[] datas = {"스피너1", "스피너2", "스피너3", "스피너4", "스피너5", "스피너6"};

    Spinner spin1;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin1 = (Spinner)findViewById(R.id.spinner);
        text1 = (TextView)findViewById(R.id.textView);


        // 어댑터 생성
        // 기본 상태의 스피너
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datas);

        // 터치시 드랍다운으로 나타나는 항목 리스트 뷰
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 어댑터를 스피너에 적용
        spin1.setAdapter(adapter1);


        SpinnerListener spinnerListener = new SpinnerListener();
        spin1.setOnItemSelectedListener(spinnerListener);
    }


    public void btnMethod(View view) {
        // 현재 스피너에서 선택한 항목의 인덱스 값을 얻는
        text1.setText("선택된 항목 : " + datas[spin1.getSelectedItemPosition()]);
    }


    class SpinnerListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            text1.setText("바로 선택 : " + datas[position]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}