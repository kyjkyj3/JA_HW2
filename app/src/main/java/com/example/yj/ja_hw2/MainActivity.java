package com.example.yj.ja_hw2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   //레이아웃과 연결하는 부분
        Log.i("YJ","OnCreate");

        Button startAddActivity = (Button)findViewById(R.id.btn_adress);
        startAddActivity .setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AdressActivity.class));
            }
        });
        Button startSerActivity = (Button)findViewById(R.id.btn_serviceactivity);
        startSerActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ServiceActivity.class));
            }
        });
        Button finishActivity= (Button)findViewById(R.id.btn_mainfinish);
        finishActivity.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v) {
                finish();
             }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("YJ","OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("YJ","OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("YJ","OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("YJ","OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("YJ","OnDestroy");
    }
}
