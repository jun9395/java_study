package com.ssafy.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    SeekBar bar1, bar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);

        bar1 = (SeekBar)findViewById(R.id.seekBar);
        bar2 = (SeekBar)findViewById(R.id.seekBar2);


        SeekListener seekListener = new SeekListener();
        bar1.setOnSeekBarChangeListener(seekListener);
        bar2.setOnSeekBarChangeListener(seekListener);
    }


    public void btn1Method(View view) {
        bar1.incrementProgressBy(1);
        bar2.incrementProgressBy(1);
    }


    public void btn2Method(View view) {
        bar1.incrementProgressBy(-1);
        bar2.incrementProgressBy(-1);
    }


    public void setMethod(View view) {
        bar1.setProgress(5);
        bar2.setProgress(5);
    }


    public void getMethod(View view) {
        text1.setText("seek1 : " + bar1.getProgress());
        text2.setText("seek2 : " + bar2.getProgress());
    }


    class SeekListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            switch (seekBar.getId()) {
                case R.id.seekBar :
                    text1.setText("첫 번째 SeekBar : " + progress);
                    break;
                case R.id.seekBar2 :
                    text1.setText("두 번째 SeekBar : " + progress);
            }

            if (fromUser)
                text2.setText("사용자에 의해 변경됐습니다");
            else
                text2.setText("코드를 통해 변경됐습니다");
        }


        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            switch (seekBar.getId()) {
                case R.id.seekBar :
                    text2.setText("첫 번째 SeekBar를 터치 중입니다");
                    break;
                case R.id.seekBar2 :
                    text2.setText("두 번째 SeekBar를 터치 중입니다");
            }
        }


        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            switch (seekBar.getId()) {
                case R.id.seekBar :
                    text2.setText("첫 번째 SeekBar를 터치를 끝냈습니다");
                    break;
                case R.id.seekBar2 :
                    text2.setText("두 번째 SeekBar를 터치를 끝냈습니다");
            }
        }
    }
}