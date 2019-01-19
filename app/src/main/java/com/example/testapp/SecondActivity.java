package com.example.testapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.String;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        final TextView callkey = (TextView) findViewById(R.id.callkey);
        final TextView callnum = (TextView) findViewById(R.id.callnum);

        Button callbtn = (Button) findViewById(R.id.callbtn);

        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keystr = callkey.getText().toString();
                int numstr = Integer.parseInt(callnum.getText().toString());

                String filename = "Contacts";
                String fileContents = keystr + ":"  + numstr;
                FileOutputStream outputStream;

                try {
                    outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                    outputStream.write(fileContents.getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
