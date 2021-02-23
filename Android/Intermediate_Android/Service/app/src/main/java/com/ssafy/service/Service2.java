package com.ssafy.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class Service2 extends IntentService {
    public Service2() {
        // Intent Service는 서비스가 동작할 때 부모 클래스에게 Service의 이름을 전달해주어야 한다
        super("Service2");
    }

    // 별도의 쓰레드가 발생되어 처리되는 메서드
    // Intent Service가 실행되면 자동으로 호출
    @Override
    protected void onHandleIntent(Intent intent) {
        for (int i = 0; i < 10; i++) {
            SystemClock.sleep(1000);
            long time = System.currentTimeMillis();
            Log.d("test", "Service2 Running... : " + time);
        }
    }
}