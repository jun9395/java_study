package com.ssafy.asynctaskclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView);
        text2 = findViewById(R.id.textView2);


        // asynctask 가동
        AsyncTaskClass async = new AsyncTaskClass();
        async.execute(10, 20);  // 전달 인자는 모두 Type1 형태의 배열로 만들어져서 doInBackground로 전달
    }


    public void timeNowMethod(View view) {
        long now = System.currentTimeMillis();
        text1.setText("버튼 클릭 : " + now);
    }


    // 첫 번째 제네릭 : execute 메서드의 매개 변수, doInBackground 메서드의 매개 변수 타입
    // 두 번째 제네릭 : publicProgress 메서드의 매개 변수, onProgressUpdate 메서드의 매개 변수 타입
    // 세 번째 제네릭 : doInBackground 메서드의 반환 타입, onPostExecute 메서드의 매개 변수 타입
    class AsyncTaskClass extends AsyncTask<Integer, Long, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            text2.setText("AsyncTask 가동");
        }


        @Override
        protected String doInBackground(Integer... integers) {
            int a1 = integers[0];
            int a2 = integers[1];

            for (int i = 0; i < 10; i++) {
                SystemClock.sleep(1000);
                a1++;
                a2++;
                Log.d("text", i + " : " + a1 + ", " + a2);

                // 화면 처리
                long now = System.currentTimeMillis();
                publishProgress(now);
            }
            return "처리가 되었습니다";
        }


        // doInBackground 메서드에서 화면 처리를 요청하면 메인 쓰레드가 호출하는 메서드
        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            text2.setText("async : " + values[0]);
        }


        // doInBackground의 수행이 완료되면 메인 쓰레드가 호출하는 메서드
        // doInBackground가 반환하는 값을 매개변수로 받는다
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            text2.setText(s);
        }
    }
}