package com.ssafy.sqlite1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    // 생성자
    public DBHelper (Context context) {
        // 액티비티가 컨텍스트를 상속받으므로 액티비티를 넘겨주면 된다
        // 두번째 매개변수가 사용할 DB 이름 입력
            // SQLiteOpenHelper의 객체를 생성할 때 부모클래스 생성자에게 사용할 DB의 이름을 넘겨주어야 한다
        // 데이터베이스를 오픈할 때 사용할 팩토리 클래스 지정하기
        // 버전
        super(context, "Test.db", null, 1);
    }


    // onCreate의 경우 DB 이름을 확인하여 존재하지 않으면 호출되어
    // 초기 데이터를 작업하도록 해주는 메서드
    // 안드로이드OS에게 처리를 요구하기 위한 쿼리문이 db에 들어온다
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("test", "데이터베이스가 생성되었습니다");

        String sql = "CREATE TABLE TestTable("
                + "idx INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "textData TEXT NOT NULL, "    // 문자열
                + "intData INTEGER NOT NULL, "  // 정수
                + "floatData REAL NOT NULL, "   // 실수
                + "dateData DATE NOT NULL"    // 날짜
                + ");";

        // INSERT UPDATE DELETE CREATE는 EXEC 쿼리 사용
        // SELECT는 조금 다르다

        db.execSQL(sql);
    }


    // super의 매개변수의 version이 변경되면,
    // onCreate는 최신 DB의 table을 만드는 코드로 작성
    // onUpgrade는 oldVersion과 newVersion에 매개변수가 들어가면서
    // 새로운 DB table로 변경되도록 작업하기 위한 메서드
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("text", "old : " + oldVersion);
        Log.d("text", "new : " + newVersion);

        switch (oldVersion) {
            case 1:
                // 1에서 2버전 형태로 테이블 구조를 변경시키는 작업
            case 2:
                // 2에서 3버전 형태로 테이블 구조를 변경시키는 작업
            case 3:
                // 3에서 4버전 형태로 테이블 구조를 변경시키는 작업
        }
    }
}
