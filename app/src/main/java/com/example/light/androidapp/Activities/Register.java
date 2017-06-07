package com.example.light.androidapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.light.androidapp.R;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Register extends AppCompatActivity {

    Socket client;
    Boolean isError=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button register=(Button) findViewById(R.id.register_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStreamWriter writer;
                        try {
                            client = new Socket(InetAddress.getByName("192.168.0.102"), 11155);
                            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                            //writer=new OutputStreamWriter(client.getOutputStream());
                            PrintWriter print = new PrintWriter(client.getOutputStream());
                            EditText username = (EditText) findViewById(R.id.register_username);
                            EditText email = (EditText) findViewById(R.id.register_email);
                            EditText password = (EditText) findViewById(R.id.register_password);
                            EditText password2 = (EditText) findViewById(R.id.register_password2);


                            TextView usernametv = (TextView) findViewById(R.id.register_usernametv);
                            try {
                                usernametv.setText("");
                            }catch (Exception ex){}
                            TextView emailtv = (TextView) findViewById(R.id.register_emailtv);
                            try {
                                emailtv.setText("");
                            }catch (Exception ex){}
                            TextView passwordtv = (TextView) findViewById(R.id.register_passwordtv);
                            try {
                                passwordtv.setText("");
                            }catch (Exception ex){}
                            if (password.getText().toString().equals(password2.getText().toString())) {
                                print.println("register" + "\r");
                                print.flush();
                                print.println(username.getText() + "\r");
                                print.flush();
                                print.println(email.getText() + "\r");
                                print.flush();
                                print.println(password.getText() + "\r");
                                print.flush();


                                Log.d("SERVER", "emailcheck");

                                String emailCheck=reader.readLine();
                                String userCheck=reader.readLine();
                                if (emailCheck.equals( "emailfail")) {
                                    try {
                                        Log.d("SERVER", "emailfail");
                                        emailtv.setText("email already taken");
                                    } catch (Exception ex) {
                                    }
                                } else Log.d("SERVER", "emailgood");
                                Log.d("SERVER", "userCheck");
                                if (userCheck.equals("userfail")) {
                                    try {
                                        Log.d("SERVER", "userfail");
                                        usernametv.setText("user already taken");
                                    } catch (Exception ex) {
                                    }
                                } else Log.d("SERVER", "userGood");
                            } else {
                                try {
                                    passwordtv.setText("Password didn't match");
                                } catch (Exception ex) {
                                }
                            }
                            Log.d("SERVER", "reader");
                            String registerCheck=reader.readLine();
                            if(registerCheck.equals("registergood")){
                                Intent login=new Intent(getBaseContext(),Login.class);
                                startActivity(login);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }).start();
            }
        });
        Button register_cancel=(Button) findViewById(R.id.register_cancel);
        register_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Login=new Intent(getBaseContext(),Login.class);
                startActivity(Login);
            }
        });


        }
}
