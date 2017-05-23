package com.example.light.androidapp.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.example.light.androidapp.MainActivity;
import com.example.light.androidapp.R;

public class Splash extends AppCompatActivity {

   final  Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);




        new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                ProgressBar pb = (ProgressBar) findViewById(R.id.splashScreenProgressBar);
                while (i<100) {
                    try {
                        pb.setProgress(pb.getProgress() + 1);
                        Thread.sleep(50);
                        i++;
                        if(pb.getProgress()==pb.getMax()){
                            pb.setProgress(0);
                        }
                    } catch (InterruptedException e) {
                    }

                }
                Intent login=new Intent(context,Login.class);
                startActivity(login);
            }
        }).start();
    }
}


