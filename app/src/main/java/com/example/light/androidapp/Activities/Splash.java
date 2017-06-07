package com.example.light.androidapp.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

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
                checkNetwork();
                Intent login=new Intent(context,Login.class);
                startActivity(login);
                finish();
            }
        }).start();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    private void checkNetwork() {
        if (!isNetworkAvailable()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context)
                    .setTitle("No Network")
                    .setMessage("Turn on Wireless or Cellular Data and try again.")
                    .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            checkNetwork();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

}


