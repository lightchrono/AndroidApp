package com.example.light.androidapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.light.androidapp.R;

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
                        //aici scrii

                    }
                }).start();
            }
        });
    }
}
