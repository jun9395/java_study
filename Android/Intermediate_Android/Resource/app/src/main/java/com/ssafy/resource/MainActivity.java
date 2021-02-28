package com.ssafy.resource;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.Resources;
import android.graphics.Color;
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


    public void changeXMLString(View view) {
//        Resources res = getResources();
//        String str2 = res.getString(R.string.str2);
//        text1.setText(str2);

        // 문자열의 경우, TextView만큼만은 이렇게도 설정 가능
        text1.setText(R.string.str2);
    }


    public void changeXMLStringArray(View view) {
        Resources res = getResources();
        String[] array = res.getStringArray(R.array.data_array);

        text1.setText("");
        for (String str1 : array) {
            text1.append(str1 + "\n");
        }
    }


    public void changeMyTextColor(View view) {
//        text1.setTextColor(Color.RED);
//        int color = Color.rgb(26, 106, 129);
        int color = Color.argb(50, 100, 150, 241);
        text1.setTextColor(color);
    }


    public void changeXMLTextColor(View view) {
        // 안드로이드마다 색감이 달라보일 수 있는데, 이 코드를 통해 모든 단말기가 비슷한 색상을 보이도록
//        int color = ContextCompat.getColor(this, R.color.color1);
//        int color = ContextCompat.getColor(this, R.color.color2);
        int color = ContextCompat.getColor(this, R.color.color4);

        text1.setTextColor(color);
    }


    public void changeMyXMLSize(View view) {
        Resources res = getResources();

        float px = res.getDimension(R.dimen.px);
        float dp = res.getDimension(R.dimen.dp);
        float sp = res.getDimension(R.dimen.sp);
        float inch = res.getDimension(R.dimen.inch);
        float mm = res.getDimension(R.dimen.mm);
        float pt = res.getDimension(R.dimen.pt);

        text1.setText("px : " + px + "\n");
        text1.append("dp : " + dp + "\nsp : " + sp + "\ninch : " + inch);
        text1.append("\nmm : " + mm + "\npt : " + pt);

        text1.setTextSize(20 * dp);
    }
}