package com.ssafy.fileinputoutput;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


/// 이 주석에 달린 것은 안드로이드 10부터는 사용 불가능하다
public class MainActivity extends AppCompatActivity {

    TextView text1;

    /// 확인받을 권한 목록
    String[] permission_list = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    /// 외부 저장소까지의 경로를 담을 변수
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView);

        checkPermission();
        /// 저장할 외부 저장소의 경로 구하기
        File f1 = Environment.getExternalStorageDirectory();
        String a1 = f1.getAbsolutePath();
        /// 패키지명을 구한다
        String a2 = getPackageName();

        path = a1 + "/android/data/" + a2;
    }


    public void writeMyFile(View view) {
        try {
            // OpenFile 메서드를 이용하여 스트림을 얻는다
            // 내부 저장소와 연결되어 있는 쓰기 스트림 추출
            // MODE_PRIVATE는 파일을 덮어쓰기, MODE_APPEND는 파일에 더해쓰기
            FileOutputStream fos = openFileOutput("myFile.dat", MODE_PRIVATE);
            DataOutputStream dos = new DataOutputStream(fos);

            // 데이터를 쓴다
            dos.writeInt(100);
            dos.writeDouble(11.11);
            dos.writeBoolean(true);
            dos.writeUTF("문자열1");

            // 파일 스트림을 닫는다
            dos.flush();
            dos.close();

            text1.setText("내부 저장소 쓰기 완료");
        } catch (Exception e) { // IOException 발생
            e.printStackTrace();
        }
    }


    public void readMyFile(View view) {
        try {
            FileInputStream fis = openFileInput("myFile.dat");
            DataInputStream dis = new DataInputStream(fis);

            int data1 = dis.readInt();
            double data2 = dis.readDouble();
            boolean data3 = dis.readBoolean();
            String data4 = dis.readUTF();

            dis.close();

            text1.setText("data1 : " + data1 + "\ndata2 : " + data2 + "\ndata3 : " + data3);
            text1.append("\ndata4 : " + data4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void writeMyOutFile(View view) {
        try {
            checkExternalDirectory();

            FileOutputStream fos = new FileOutputStream(path + "/sd_file.dat");
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeInt(200);
            dos.writeDouble(22.22);
            dos.writeBoolean(false);
            dos.writeUTF("문자열2");

            dos.flush();
            dos.close();

            text1.setText("외부 저장소 쓰기 완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void readMyOutFile(View view) {
        try {
            FileInputStream fis = new FileInputStream(path + "/sd_file.dat");
            DataInputStream dis = new DataInputStream(fis);

            int data1 = dis.readInt();
            double data2 = dis.readDouble();
            boolean data3 = dis.readBoolean();
            String data4 = dis.readUTF();

            dis.close();

            text1.setText("data1 : " + data1 + "\ndata2 : " + data2 + "\ndata3 : " + data3);
            text1.append("\ndata4 : " + data4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void checkPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }

        for (String permission : permission_list) {
            if (checkCallingOrSelfPermission(permission) == PackageManager.PERMISSION_DENIED) {
                requestPermissions(permission_list, 0);
                break;
            }
        }
    }


    public void checkExternalDirectory() {
        /// 외부 저장소 경로가 있는지 확인하고 없으면 생성
        File file = new File(path);

        if (!file.exists()) { file.mkdir(); }
    }
}