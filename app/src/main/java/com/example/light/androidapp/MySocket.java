package com.example.light.androidapp;

import android.app.Application;

import java.net.Socket;

/**
 * Created by light on 6/6/2017.
 */

public class MySocket extends Application {
    private Socket socket;

    public MySocket(){}

    public void setSocket(Socket socket)
    {
        this.socket=socket;
    }
    public Socket getSocket(){
        return socket;
    }
}