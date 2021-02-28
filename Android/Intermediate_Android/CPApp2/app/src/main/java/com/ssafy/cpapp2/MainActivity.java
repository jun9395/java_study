package com.ssafy.cpapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView);
    }


    public void insertOtherApp(View view) {
        // 저장할 데이터 준비
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date = sdf.format(new Date());

        ContentValues cv1 = new ContentValues();
        cv1.put("textData", "문자열1");
        cv1.put("intData", 100);
        cv1.put("floatData", 11.11);
        cv1.put("dateData", date);

        ContentValues cv2 = new ContentValues();
        cv2.put("textData", "문자열2");
        cv2.put("intData", 200);
        cv2.put("floatData", 22.22);
        cv2.put("dateData", date);


        // 접속할 Content Provider의 이름이 담긴 객체 생성
        Uri uri = Uri.parse("content://com.ssafy.dbprovider");

        // Content Provider에 작업을 요청하기 위한 객체를 가져온다
        ContentResolver resolver = getContentResolver();

        // 데이터 INSERT 작업을 '요청'한다
        resolver.insert(uri, cv1);
        resolver.insert(uri, cv2);
        text1.setText("저장 완료");
    }


    public void selectOtherApp(View view) {
        Uri uri = Uri.parse("content://com.ssafy.dbprovider");

        ContentResolver resolver = getContentResolver();

        // 데이터를 받아온다
        Cursor c = resolver.query(uri, null, null, null, null);

        text1.setText("");

        while (c.moveToNext()) {
            int idx_pos = c.getColumnIndex("idx");
            int text_pos = c.getColumnIndex("textData");
            int int_pos = c.getColumnIndex("intData");
            int float_pos = c.getColumnIndex("floatData");
            int date_pos = c.getColumnIndex("dateData");

            int idx = c.getInt(idx_pos);
            String textData = c.getString(text_pos);
            int intData = c.getInt(int_pos);
            double floatData = c.getDouble(float_pos);
            String dateData = c.getString(date_pos);

            text1.append("idx : " + idx + "\ntextData : " + textData + "\nintData : " + intData);
            text1.append("\nfloatData : " + floatData + "\ndateData : " + dateData + "\n\n");
        }
    }


    public void updateOtherApp(View view) {
        ContentValues cv = new ContentValues();
        cv.put("textData", "문자열100");
        String where = "idx=?";
        String[] args = {"1"};

        Uri uri = Uri.parse("content://com.ssafy.dbprovider");

        ContentResolver resolver = getContentResolver();

        resolver.update(uri, cv, where, args);

        text1.setText("수정완료");
    }


    public void deleteOtherApp(View view) {
        String where = "idx=?";
        String[] args = {"1"};

        Uri uri = Uri.parse("content://com.ssafy.dbprovider");
        ContentResolver resolver = getContentResolver();
        resolver.delete(uri, where, args);
        text1.setText("삭제 완료");
    }
}