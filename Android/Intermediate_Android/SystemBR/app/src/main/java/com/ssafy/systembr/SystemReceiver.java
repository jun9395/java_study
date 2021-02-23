package com.ssafy.systembr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SystemReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

//        Toast t = Toast.makeText(context, "브로드 캐스트 리시버 동작", Toast.LENGTH_LONG);
//        t.show();

        // 안드로이드 OS가 리시버를 찾기 위해 사용했던 이름 추출
        String action = intent.getAction();

        // 리시버의 이름으로 분기
        // 이름 당 리시버 하나씩 만들어서 사용해도 된다
        switch (action) {
            case "android.intent.action.BOOT_COMPLETED":
                Toast t1 = Toast.makeText(context, "부팅완료", Toast.LENGTH_LONG);
                t1.show();
                break;
            case "android.provider.Telephony.SMS_RECEIVED":
                // SMS는 배열 형태로 전달된다
                // 문자 메시지 정보를 갖고 있는 객체 추출
                Bundle bundle = intent.getExtras(); // intent 안의 객체를 한번에 추출
                if (bundle != null) {
                    // 번들에서 문자 메시지 정보 객체를 추출
                    Object[] obj = (Object [])bundle.get("pdus");
                    // 문자 메시지 정고 객체를 이용해 SmsMessage 객체 생성
                    SmsMessage[] msg = new SmsMessage[obj.length];
                    for (int i = 0; i < obj.length; i++) {
                        msg[i] = SmsMessage.createFromPdu((byte[])obj[i]);
                    }

                    // 문자 메시지 정보 추출
                    for (SmsMessage a1 : msg) {
                        String number = a1.getOriginatingAddress(); // 발신자 전화번소
                        String str = a1.getMessageBody();
                        String a2 = number + " : " + str;
                        Toast t2 = Toast.makeText(context, a2, Toast.LENGTH_LONG);
                        t2.show();
                        break;
                    }
                }
            default:
                Toast tt = Toast.makeText(context, "디폴트 메시지", Toast.LENGTH_SHORT);
                tt.show();
        }
    }
}