package com.ssafy.listdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView text1;

    // 기본적인 리스트 다이얼로그는 항목 1개당 문자열 1개
    String[] datas = {"항목1", "항목2", "항목3", "항목4", "항목5", "항목6", "항목7", "항목8"};

    // 커스텀리스트 다이얼로그 구성을 위한 데이터 배열
    String[] datas2 = {"토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국"};
    int[] datas3 = {R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3, R.drawable.imgflag4,
            R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
    }


    public void normalListMethod(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("리스트 다이얼로그");
        builder.setNegativeButton("취소", null);


        ListDialogListener listener = new ListDialogListener();

        // setItems라는 메서드 안에 문자열이 들어있는 배열이나 어레이를 담아주면
        // 이를 이용해서 리스트 뷰를 만들어서 구성해준다
        // 리스트 다이얼로그 구성을 위한 문자열 배열 설정
        builder.setItems(datas, listener);

        builder.show();
    }


    class ListDialogListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            text1.setText("기본 리스트 다이얼로그 : " + datas[which]);
        }
    }


    public void CustomListMethod(View view) {
        // 리스트뷰 구성을 위해 필요한 데이터를 ArrayList에 담는다
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

        for (int i = 0; i < datas2.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("datas2", datas2[i]);
            map.put("datas3", datas3[i]);

            list.add(map);
        }

        String[] keys = {"datas2", "datas3"};
        int[] ids = {R.id.textView2, R.id.imageView};

        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.row, keys, ids);


        // 다이얼로그 세팅
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("커스텀 리스트 다이얼로그");

        // 어댑터 세팅
        CustomListener listener = new CustomListener();

        builder.setAdapter(adapter, listener);

        builder.setNegativeButton("취소", null);
        builder.show();
    }


    class CustomListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            text1.setText("커스텀 리스트 다이얼로그 : " + datas2[which]);
        }
    }
}