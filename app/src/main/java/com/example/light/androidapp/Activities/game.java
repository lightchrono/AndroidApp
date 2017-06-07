package com.example.light.androidapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.light.androidapp.MySocket;
import com.example.light.androidapp.R;

import java.net.Socket;

public class game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        MySocket sock=(MySocket) getApplication();
        final Socket socket = sock.getSocket();

        Button a1=(Button) findViewById(R.id.game_a1);
        Button a2=(Button) findViewById(R.id.game_a2);
        Button a3=(Button) findViewById(R.id.game_a3);
        Button a4=(Button) findViewById(R.id.game_a4);


    }
}
