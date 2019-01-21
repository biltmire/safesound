package com.hrupin.speechrecognitionservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_screen);

        final TextView callkey = (TextView) findViewById(R.id.msgkey);
        final TextView callnum = (TextView) findViewById(R.id.msgnum);

        Button callbtn = (Button) findViewById(R.id.msgbtn);

        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}


