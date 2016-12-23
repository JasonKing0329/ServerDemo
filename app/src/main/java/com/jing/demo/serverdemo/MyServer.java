package com.jing.demo.serverdemo;

import org.nanohttpd.protocols.http.IHTTPSession;
import org.nanohttpd.protocols.http.NanoHTTPD;
import org.nanohttpd.protocols.http.response.Response;

import java.io.IOException;
import java.util.Map;

/**
 * Created by 景阳 on 2016/12/23.
 */

public class MyServer extends NanoHTTPD {

    public MyServer(int port) throws IOException {
        super(port);
    }

    public MyServer(String hostname, int port) throws IOException {
        super(hostname, port);
    }

    @Override
    protected Response serve(IHTTPSession session) {
        String msg = "<html><body><h1>Hello server</h1>\n";
        Map<String, String> parms = session.getParms();
        if (parms.get("username") == null) {
            msg += "<form action='?' method='get'>\n  <p>Your name: <input type='text' name='username'></p>\n" + "</form>\n";
        } else {
            msg += "<p>Hello, " + parms.get("username") + "!</p>";
        }
        return Response.newFixedLengthResponse(msg);
    }
}
