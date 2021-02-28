package com.ssafy.cpapp1;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class TestProvider extends ContentProvider {
    public TestProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        DBHelper helper = new DBHelper(getContext());
        SQLiteDatabase db = helper.getWritableDatabase();

        int cnt = db.delete("TestTable", selection, selectionArgs);

        return cnt;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // 다른 어플리케이션에서 INSERT 작업을 요청하면 호출되는 메서드
    // Uri uri에는 컨텐츠 프로바이더의 이름, 이 파일에서는 com.ssafy.testprovider가 담긴 객체가 들어온다
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        DBHelper helper = new DBHelper(getContext());
        SQLiteDatabase db = helper.getWritableDatabase();

        // 저장하기
        db.insert("TestTable", null, values);

        return uri;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }


    // SELECT 작업 요청시 호출되는 메서드
    // projection이 가져올 컬럼 목록
    // selection이 조건절
    // selectionArgs가 조건절 ?의 값
    // sortOrder 정렬 기준
    //
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        DBHelper helper = new DBHelper(getContext());
        SQLiteDatabase db = helper.getWritableDatabase();

        // 불러오기
        // groupby와 having은 넘어오는 게 없으니까 null로 준다
        Cursor c = db.query("TestTable", projection, selection, selectionArgs, null, null, sortOrder);

        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        DBHelper helper = new DBHelper(getContext());
        SQLiteDatabase db = helper.getWritableDatabase();

        // 업데이트
        // 몇 개의 row가 변경됐는지 반환함
        int cnt = db.update("TestTable", values, selection, selectionArgs);

        return cnt;
    }
}