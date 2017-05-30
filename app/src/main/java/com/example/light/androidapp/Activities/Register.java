package com.example.light.androidapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.light.androidapp.R;

import java.io.DataInputStream;
import java.io.IOException;
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
        Button register=(Button) findViewById(R.id.RregisterB);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStreamWriter writer;
                        DataInputStream reader;
                        try
                        {
                            client=new Socket(InetAddress.getByName("5.15.180.8"),25565);
                            reader=new DataInputStream (client.getInputStream());
                            //writer=new OutputStreamWriter(client.getOutputStream());
                            PrintWriter print=new PrintWriter(client.getOutputStream());
                            print.println("register");print.flush();
                            print.println("username");print.flush();
                            print.println("email");print.flush();
                            print.println("password");print.flush();

                            Log.d("LOG",reader.readLine());
                            Log.d("SERVER","Waiting");
                            String str=reader.readLine();
                            Log.d("SERVER",str);
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
    }
}
