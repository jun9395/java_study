package com.ssafy.brapp1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TestReceiver extends BroadcastReceiver {

    // 안드로이드 OS가 이 Receiver를 동작해야 할 때
    // 이 Class의 객체를 생성한 뒤에 onReceive 메서드를 실행한다
    // Receiver 동작 때 Intent에 데이터를 담아 넘겨줄 수 있다
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String str = "브로드 캐스트 리시버가 동작했습니다";
        // 첫 번째 매개변수로 content를 상속받은 객체를 넘겨줘야 하는데,
        // Activity의 경우 context를 상속하으므로 this로 하지만 BroadCastReceiver는 그렇지 않다
        // 그래서 context로 전달
        Toast t1 = Toast.makeText(context, str, Toast.LENGTH_LONG);
        t1.show();
    }
}