package com.jing.demo.serverdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActivity", "wifi:" + IPUtil.getWifiIpAddress(this));
        startService(new Intent().setClass(this, MyServerService.class));
    }
}
