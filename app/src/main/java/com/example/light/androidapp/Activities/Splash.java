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

    Activity context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        context=this;

        new Thread(new Runnable() {
            @Override
            public void run() {
                ProgressBar pb = (ProgressBar) findViewById(R.id.splashScreenProgressBar);
                while (true) {
                    try {
                        pb.setProgress(pb.getProgress() + 1);
                        Thread.sleep(50);
                        if(pb.getProgress()==pb.getMax()){
                            pb.setProgress(0);
                        }
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();


        while (true) {
            boolean connected = false;
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                //we are connected to a network
                connected = true;
            } else
                connected = false;
            if (connected) {
                Intent login = new Intent(context, MainActivity.class);
                startActivity(login);
                finish();
            } else {
                AlertDialog.Builder noNetwork = new AlertDialog.Builder(context);
                noNetwork.setMessage("No network Connection")
                        .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                noNetwork.show();
            }

        }

    }
}


