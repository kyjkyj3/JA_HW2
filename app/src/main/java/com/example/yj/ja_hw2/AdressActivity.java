package com.example.yj.ja_hw2;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.yj.ja_hw2.ContentResolver.AddressResolver;

import java.util.ArrayList;


public class AdressActivity extends Activity {
    public String[] nameList;
    public String[] phoneList;

    ArrayList<String> list;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress);

        list = AddressResolver.getContactsData(this, nameList,phoneList);  //주소록에서 주소 가져오기

        ListView listview= (ListView)findViewById(R.id.lv_adress);
        arrayAdapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,list);
        listview.setAdapter(arrayAdapter);
    }




}
