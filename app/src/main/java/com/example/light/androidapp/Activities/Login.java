package com.example.light.androidapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.light.androidapp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Login extends AppCompatActivity {

    Activity activity=this;
    Socket socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Button registerB=(Button) findViewById(R.id.RegisterB);
        registerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerI=new Intent(activity,Register.class);
                startActivity(registerI);
            }
        });

       Button loginB=(Button) findViewById(R.id.login_loginB);
        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Socket","Button pressed");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Log.d("Socket","Trying to connect...");
                            socket=new Socket(InetAddress.getByName("192.168.1.49"),11155);
                            Log.d("Socket","Connection on");
                            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            PrintWriter writer=new PrintWriter(socket.getOutputStream(),true);
                            writer.print("login"+"\r\n");writer.flush();
                            writer.print("q"+"\r\n");writer.flush();
                            writer.print("q"+"\r\n");writer.flush();
                            String str=reader.readLine();
                            Log.d("Socket",str );

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
}
