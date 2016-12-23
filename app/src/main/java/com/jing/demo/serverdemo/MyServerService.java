package com.jing.demo.serverdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import org.nanohttpd.protocols.http.*;
import org.nanohttpd.protocols.http.NanoHTTPD;

import java.io.IOException;

public class MyServerService extends Service {

    private MyServer server;

    public MyServerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.e("MyServerService", "onStartCommand");
        try {
            server = new MyServer(IPUtil.getWifiIpAddress(this), 8080);
            server.start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("MyServerService", "onDestroy");
        if (server != null) {
            server.stop();
        }
        super.onDestroy();
    }
}
