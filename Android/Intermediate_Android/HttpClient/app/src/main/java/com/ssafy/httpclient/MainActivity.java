package com.ssafy.httpclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView);
    }


    public void ConnectHTTPServer(View view) {
        NetworkThread thread = new NetworkThread();
        thread.start();
    }


    class NetworkThread extends Thread {
        @Override
        public void run() {
            try {
                String site = "http://172.30.1.36:8081/basicserver/basic.jsp";
                URL url = new URL(site);

                // 접속
                URLConnection conn = url.openConnection();

                // 서버와 연결된 스트림 추출
                InputStream is = conn.getInputStream();

                // UTF-8 형식으로 받아야 한다
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);

                // 스트링 버퍼를 준비해서 옮겨담는다
                String str1 = null;
                StringBuffer buf = new StringBuffer();

                // 읽어온다
                do {
                    str1 = br.readLine();
                    if (str1 != null) {
                        buf.append(str1);
                    }
                } while (str1 != null);

                final String str2 = buf.toString();

                runOnUiThread(() -> { text1.setText(str2); });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}