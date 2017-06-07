package com.example.light.androidapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.light.androidapp.MySocket;
import com.example.light.androidapp.R;

import java.io.IOException;
import java.net.Socket;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        MySocket sock = (MySocket) getApplication();
        final Socket socket = sock.getSocket();

        Button play=(Button) findViewById(R.id.menu_start);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),FirstPlayer.class);
                startActivity(intent);
                finish();
            }
        });

        Button menu_logout=(Button) findViewById(R.id.menu_logout);
        menu_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent Login=new Intent(getBaseContext(),Login.class);
                startActivity(Login);
                finish();
            }
        });

        Button menu_exit=(Button) findViewById(R.id.menu_exit);
        menu_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }


        });
    }
}
