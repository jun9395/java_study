package com.ssafy.sqlite2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper (Context context) {
        super(context, "Test.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE TestTable ("
                + "idx INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "textData TEXT NOT NULL, "
                + "intData INTEGER NOT NULL, "
                + "floatData REAL NOT NULL, "
                + "dateData DATE NOT NULL);";

        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
