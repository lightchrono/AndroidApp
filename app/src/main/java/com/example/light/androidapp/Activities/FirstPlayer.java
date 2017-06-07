package com.example.light.androidapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.light.androidapp.MySocket;
import com.example.light.androidapp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FirstPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_player);

        TextView winorlose=(TextView)findViewById(R.id.winorlose);

        MySocket sock=(MySocket) getApplication();
        final Socket socket = sock.getSocket();

        Button rockButton=(Button)findViewById(R.id.first_rockbutton);
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            PrintWriter writer=new PrintWriter(socket.getOutputStream(),true);
                            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            writer.write("rock\r");writer.flush();
                            Log.d("Socket",reader.readLine());
                            Intent test=new Intent(getBaseContext(),game.class);
                            startActivity(test);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();

            }
        });
        Button paperButton=(Button)findViewById(R.id.first_paperbutton);
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            PrintWriter writer=new PrintWriter(socket.getOutputStream(),true);
                            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            writer.write("paper\r");writer.flush();
                            Log.d("Socket",reader.readLine());
                            Intent test=new Intent(getBaseContext(),game.class);
                            startActivity(test);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
            }
        });

        Button scissorsButton=(Button)findViewById(R.id.first_scissorsbutton);
        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            PrintWriter writer=new PrintWriter(socket.getOutputStream(),true);
                            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            writer.write("scissor\r");writer.flush();
                            Log.d("Socket",reader.readLine());
                            Intent test=new Intent(getBaseContext(),game.class);
                            startActivity(test);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
            }
        });

    }
}
