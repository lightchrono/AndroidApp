package com.example.light.androidapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.light.androidapp.MySocket;
import com.example.light.androidapp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        MySocket sock = (MySocket) getApplication();
        final Socket socket = sock.getSocket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    Log.d("game", reader.readLine());
                    Log.d("game", reader.readLine());

                } catch (Exception ex) {
                }
            }
        }).start();

        Button a1 = (Button) findViewById(R.id.game_a1);
        Button a2 = (Button) findViewById(R.id.game_a2);
        Button a3 = (Button) findViewById(R.id.game_a3);
        Button a4 = (Button) findViewById(R.id.game_a4);
        Button concede = (Button) findViewById(R.id.game_concede);

        final ProgressBar hpP1 = (ProgressBar) findViewById(R.id.game_p1);
        final ProgressBar hpBot = (ProgressBar) findViewById(R.id.game_bot);

        hpP1.setMax(100);hpBot.setMax(100);
        hpP1.setProgress(100);hpBot.setProgress(100);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            writer.write("0\r");
                            writer.flush();
                            Log.d("Socket", reader.readLine());

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    String p1HP="";String botHP="";
                   //String botHP=reader.readLine();
                    @Override
                    public void run() {
                        try {
                            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            writer.write("1\r");
                            writer.flush();
                            botHP=reader.readLine();
                            p1HP=reader.readLine();



                          //  hpP1.setProgress(Integer.parseInt(p1HP));
                           // hpBot.setProgress(Integer.parseInt(botHP));


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Log.d("HP","player: "+p1HP);
                        Log.d("HP","BOT: "+botHP);
                        try {
                            hpP1.setProgress(Integer.parseInt(p1HP));
                            hpBot.setProgress(Integer.parseInt(botHP));
                        }
                        catch (Exception ex){}
                    }
                }).start();

            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            writer.write("2\r");
                            writer.flush();
                            Log.d("Socket", reader.readLine());

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            writer.write("3\r");
                            writer.flush();
                            Log.d("Socket", reader.readLine());

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

    }
}

