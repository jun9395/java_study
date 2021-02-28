package com.ssafy.sqlite1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

        // 객체 생성만으로도 DB가 오픈된다
//        DBHelper helper = new DBHelper(this);
//        SQLiteDatabase db = helper.getWritableDatabase();
    }


    public void insertMyData(View view) {
        // 데이터베이스 오픈
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "INSERT INTO TestTable (textData, intData, floatData, dateData) "
                + "VALUES (?, ?, ?, ?);";

        // 날짜는 2021-02-25 이런 식으로 제공하자
        // 데이터 준비
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date = sdf.format(new Date());

        // ?에 바인딩될 값 배열
        String[] arg1 = {"문자열1", "100", "11.11", date};
        String[] arg2 = {"문자열2", "200", "22.22", date};

        // 저장한다
        db.execSQL(sql, arg1);
        db.execSQL(sql, arg2);

        db.close();

        text1.setText("저장완료");
    }


    public void selectMyData(View view) {
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        // 조건절이 있다면 조건절에 들어갈 값을 ?로 세팅한 다음
        // ?에 들어갈 값을 2번째 패러미터로 넣어주면 된다
        String sql = "SELECT * FROM TestTable;";    // WHERE idx = ?
        // String[] arg1 = {"1"};

        // SELECT 쿼리 실행
        // 가져온 결과에 접근할 수 있는 객체가 Cursor 객체
        Cursor c = db.rawQuery(sql, null);  // 그 후 null 대신 arg1

        text1.setText("");

        // 선택된 rows를 끝까지 반복하여 데이터를 가져온다
        while (c.moveToNext()) {
            // 컬럼의 이름을 갖고 데이터를 가져오는 방법이 없다
            // SELECT로 가져온 데이터 중에서 index 번호를 갖고 몇 번째 컬럼의 데이터를 가져오라
            // 이런 식으로 처리해야 한다
            // 컬럼의 이름만 알고 몇 번째로 나오는지 모르는 경우,
            // 컬럼의 이름으로 index 번호를 추출한 다음 index 번호를 통해서 데이터를 가져와야 한다
            int idx_pos = c.getColumnIndex("idx");
            int textData_pos = c.getColumnIndex("textData");
            int intData_pos = c.getColumnIndex("intData");
            int floatData_pos = c.getColumnIndex("floatData");
            int dateData_pos = c.getColumnIndex("dateData");

            // 컬럼 인덱스 번호를 통해 데이터를 가져온다
            int idx = c.getInt(idx_pos);
            String textData = c.getString(textData_pos);
            int intData = c.getInt(intData_pos);
            double floatData = c.getFloat(floatData_pos);
            String dateData = c.getString(dateData_pos);

            text1.append("idx : " + idx + "\ntextData : " + textData);
            text1.append("\nintData : " + intData + "\nfloatData : " + floatData);
            text1.append("\ndateDate : " + dateData + "\n\n");
        }

        db.close();
    }


    public void updateMyData(View view) {
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "UPDATE TestTable SET textData = ? WHERE idx = ?;";
        String[] args = {"문자열3", "1"};

        db.execSQL(sql, args);
        db.close();

        text1.setText("수정완료");
    }


    public void deleteMyData(View view) {
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "DELETE FROM TestTable WHERE idx=?;";
        String[] args = {"1"};

        db.execSQL(sql, args);
        db.close();

        text1.setText("삭제완료");
    }
}