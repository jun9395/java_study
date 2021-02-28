package com.ssafy.cpapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView);
    }


    public void selectMyData(View view) {
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "SELECT * FROM TestTable;";

        Cursor c = db.rawQuery(sql, null);

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

        db.close();
    }
}