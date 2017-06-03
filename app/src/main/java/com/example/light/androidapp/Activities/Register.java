package com.example.light.androidapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.light.androidapp.R;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Register extends AppCompatActivity {

    Socket client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button register=(Button) findViewById(R.id.register_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStreamWriter writer;
                        try
                        {
                            client=new Socket(InetAddress.getByName("192.168.0.102"),11155);
                            BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
                            //writer=new OutputStreamWriter(client.getOutputStream());
                            PrintWriter print=new PrintWriter(client.getOutputStream());
                            print.println("register"+"\r\n");print.flush();
                            print.println("username"+"\r\n");print.flush();
                            print.println("email"+"\r\n");print.flush();
                            print.println("password"+"\r\n");print.flush();

                            Log.d("LOG",reader.readLine());
                            Log.d("SERVER","Waiting");
                            String str=reader.readLine();
                            Log.d("SERVER",str);
                            Log.d("SERVER",reader.readLine());
                            Log.d("SERVER","Done");
                        }
                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }


                    }
                }).start();
            }
        });
        Button register_cancel=(Button) findViewById(R.id.register_cancel);
        register_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Login=new Intent(getBaseContext(),Login.class);
                startActivity(Login);
            }
        });


        }
}
