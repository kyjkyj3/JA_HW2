package com.example.yj.ja_hw2.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ScreenReceiver extends BroadcastReceiver {
    public ScreenReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            Log.i("YJ", "Screen OFF");
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            Log.i("YJ","Screen ON");
            Toast.makeText(context, "screen 켜짐", Toast.LENGTH_LONG).show();
        }
    }
}
