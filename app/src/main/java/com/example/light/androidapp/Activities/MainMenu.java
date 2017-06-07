package com.example.light.androidapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.light.androidapp.MySocket;
import com.example.light.androidapp.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        Button startPPE=(Button) findViewById(R.id.main_start);
        startPPE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    MySocket sock=(MySocket) getApplication();
                    Socket socket = sock.getSocket();
                    Log.d("ErrorSocket",socket.toString());

                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                }catch (Exception ex){
                    Log.d("ErrorSocket",ex.toString());
                }
                Intent intent = new Intent(getBaseContext(), FirstPlayer.class);
                startActivity(intent);
            }
        });
    }
}
