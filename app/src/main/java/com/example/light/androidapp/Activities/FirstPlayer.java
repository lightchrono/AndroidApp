package com.example.light.androidapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.light.androidapp.R;

public class FirstPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_player);

        Button rockButton=(Button)findViewById(R.id.first_rockbutton);
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Button paperButton=(Button)findViewById(R.id.first_paperbutton);
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button scissorsButton=(Button)findViewById(R.id.first_scissorsbutton);
        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        TextView winorlose=(TextView)findViewById(R.id.winorlose);
        //winorlose textview
        //enemychoose
    }
}
