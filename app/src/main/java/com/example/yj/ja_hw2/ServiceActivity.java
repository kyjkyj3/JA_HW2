package com.example.yj.ja_hw2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yj.ja_hw2.BroadcastReceiver.WifiBroadcastReceiver;
import com.example.yj.ja_hw2.Service.ScreenService;


public class ServiceActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        Button startService = (Button)findViewById(R.id.btn_startService);
        startService.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(),ScreenService.class));
            }
        });
        Button endService= (Button)findViewById(R.id.btn_endService);
        endService.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(),ScreenService.class));
            }
        });




    }

}
