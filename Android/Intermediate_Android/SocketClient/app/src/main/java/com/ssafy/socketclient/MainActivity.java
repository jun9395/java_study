package com.ssafy.socketclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView);
    }


    public void connectServer(View view) {
        NetworkThread thread = new NetworkThread();
        thread.start();
    }


    // 네트워크 스레드
    class NetworkThread extends Thread {
        @Override
        public void run() {
            try {
                // 서버에 접속한다
                // socket 객체에 접속할 서버의 ip 주소와 포트 번호를 입력
                // 127.0.0.1이나 localhost를 사용하면 에뮬레이터 자신을 가리키게 된다
                // ip를 통해서 컴퓨터를 찾고, 해당 컴퓨터 내의 소켓 번호에 연결하려고 한다
                final Socket socket = new Socket("172.30.1.36", 55555);

//                runOnUiThread(() -> text1.setText(socket.toString()));

                // 입출력 스트림 추출
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                DataInputStream dis = new DataInputStream(is);
                DataOutputStream dos = new DataOutputStream(os);

                final int data1 = dis.readInt();
                final double data2 = dis.readDouble();
                final boolean data3 = dis.readBoolean();
                final String data4 = dis.readUTF();

                dos.writeInt(200);
                dos.writeDouble(22.22);
                dos.writeBoolean(false);
                dos.writeUTF("클라이언트가 보낸 문자열");

                runOnUiThread(() -> {
                    text1.setText("data1 : " + data1 + "\ndata2 : " + data2);
                    text1.append("\ndata3 : " + data3 + "\ndata4 : " + data4);
                });

                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}