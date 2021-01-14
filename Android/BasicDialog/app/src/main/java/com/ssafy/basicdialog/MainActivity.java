package com.ssafy.basicdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView text1;

    ProgressDialog pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
    }


    public void DialogMethod(View view) {
        // 다이얼로그에 관한 정보를 관리하는 객체를 생성
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //제목
        builder.setTitle("기본 다이얼로그");
        //본문
        builder.setMessage("다이얼로그의 본문");
        //아이콘
        builder.setIcon(R.mipmap.ic_launcher_round);

        // 리스너 생성
        Diallog1Listener listener = new Diallog1Listener();


        // 다이얼로그의 버튼을 생성
        builder.setPositiveButton("Positive", listener);
        builder.setNeutralButton("Neutral", listener);
        builder.setNegativeButton("Negative", listener);


        // 다이얼로그를 보여준다
        builder.show();
    }


    // 다이얼로그의 리스너
    class Diallog1Listener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {

            switch (which) {
                case DialogInterface.BUTTON_POSITIVE :
                    text1.setText("Positive");
                    break;
                case DialogInterface.BUTTON_NEUTRAL :
                    text1.setText("Neutral");
                    break;
                case DialogInterface.BUTTON_NEGATIVE :
                    text1.setText("Negative");
                    break;
            }
        }
    }


    public void CustomMethod(View view) {
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle("커스텀 다이얼로그");
        builder2.setIcon(R.mipmap.ic_launcher);

        // 다이얼로그를 통해 보여줄 뷰 생성
        LayoutInflater inflater = getLayoutInflater();
        View v1 = inflater.inflate(R.layout.dialog, null);

        // 생성한 뷰를 다이얼로그에 세팅
        builder2.setView(v1);

        Dialog2Listener listener = new Dialog2Listener();

        builder2.setPositiveButton("확인", listener);
        builder2.setNegativeButton("취소", null);

        builder2.show();
    }


    class Dialog2Listener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // AlertDialog로 형변환
            AlertDialog alert = (AlertDialog)dialog;

            // AlertDialog가 갖고 있는 뷰 추출
            EditText edit1 = (EditText)alert.findViewById(R.id.editTextTextPersonName);
            EditText edit2 = (EditText)alert.findViewById(R.id.editTextTextPersonName2);


            // 사용자가 입력한 문자열을 가져온다
            String str1 = edit1.getText().toString();
            String str2 = edit2.getText().toString();

            text1.setText("edit1 : " + str1 + "\nedit2 : " + str2);
        }
    }


    public void DateMethod(View view) {
        // 오늘 날짜를 가져와야 한다
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DialogDateListener listener = new DialogDateListener();

        DatePickerDialog picker = new DatePickerDialog(this, listener, year, month, day);
        picker.show();
    }


    class DialogDateListener implements DatePickerDialog.OnDateSetListener {

        @Override
        // 사용자가 지정한 년 월 일이 들어온다
        // 월은 0부터 시작하므로 +1 해주자
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            text1.setText(year + "년 " + (month + 1) + "월 " + dayOfMonth + "일");
        }
    }


    public void TimeMethod(View vieW) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        DialogTimeListener listener = new DialogTimeListener();

        TimePickerDialog picker = new TimePickerDialog(this, listener, hour, minute, false);

        picker.show();
    }


    class DialogTimeListener implements TimePickerDialog.OnTimeSetListener {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            text1.setText(hourOfDay + "시 " + minute + "분");
        }
    }


    public void ProgressMethod(View view) {
        // ProgressDialog를 생성
        // 이렇게 하면 화면상에 바로 나타나버림
        pro = ProgressDialog.show(this, "제목입니다", "본문메시지입니다");

        // 5초 후에 progress dialog 제거를 위해 스레드
        Handler handler = new Handler();
        DialogThread thread = new DialogThread();
        handler.postDelayed(thread, 5000);  // 5000 ms 후에 thread의 run을 실행하라
    }


    // 프로그레스 다이얼로그를 위한 스레드
    class DialogThread extends Thread {
        @Override
        public void run() {
            // 현재 나타나있는 progress dialog를 제거
            pro.cancel();
        }
    }
}