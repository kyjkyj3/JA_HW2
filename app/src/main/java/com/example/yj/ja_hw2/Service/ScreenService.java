package com.example.yj.ja_hw2.Service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import com.example.yj.ja_hw2.BroadcastReceiver.ScreenReceiver;

public class ScreenService extends Service {
    public ScreenService() {
    }
    ScreenReceiver mScreenReceiver;
    @Override
    public void onCreate() {
        super.onCreate();
        mScreenReceiver = new ScreenReceiver();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        IntentFilter screenStateFilter = new IntentFilter();
        screenStateFilter.addAction(Intent.ACTION_SCREEN_ON);
        screenStateFilter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(mScreenReceiver,screenStateFilter);
        Log.i("YJ", "스크린 감지 서비스 시작!");
        return START_STICKY;  //시스템이 죽여도 다시 살린다!
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mScreenReceiver);
        Log.i("YJ", "스크린 감지 서비스 끝남!");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
