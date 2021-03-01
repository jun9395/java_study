package com.ssafy.jsonclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView);
    }


    public void ConnectJSONNetwork(View view) {
        NetworkThread thread = new NetworkThread();
        thread.start();
    }


    class NetworkThread extends Thread {
        @Override
        public void run() {
            try {
                URL url = new URL("http://172.30.1.36:8081/JSONServer/jsonbasic.jsp");
                URLConnection conn = url.openConnection();

                InputStream is = conn.getInputStream();
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                BufferedReader br = new BufferedReader(isr);

                StringBuffer buf = new StringBuffer();
                String str1 = null;

                do {
                    str1 = br.readLine();
                    if (str1 != null) {
                        buf.append(str1);
                    }
                } while (str1 != null);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        text1.setText("");
                    }
                });
                // JSON 데이터를 문자열로 쭉 읽은 상태
                String data = buf.toString();

                // JSON 배열 객체 생성
                JSONArray root = new JSONArray(data);

                for (int i = 0; i < root.length(); i++) {
                    // i번째 JSON 객체 추출
                    JSONObject obj = root.getJSONObject(i);
                    final String data1 = obj.getString("data1");
                    final int data2 = obj.getInt("data2");
                    final double data3 = obj.getDouble("data3");

                    runOnUiThread(() -> {
                        text1.append("data1 : " + data1 + "\ndata2 : " + data2 + "\ndata3 : " + data3 + "\n\n");
                    });
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}