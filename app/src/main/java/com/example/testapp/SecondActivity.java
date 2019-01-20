package com.example.testapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.String;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        final EditText callkey = (EditText) findViewById(R.id.callkey);
        final EditText callnum = (EditText) findViewById(R.id.callnum);

        Button callbtn = (Button) findViewById(R.id.callbtn);

        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keystr = callkey.getText().toString();
                int numstr = Integer.parseInt(callnum.getText().toString());
                String fileContents = keystr + ":"  + numstr;

                PrintWriter out = null;
                try{
                    out = new PrintWriter(new FileOutputStream(MainActivity.filename, true));
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                out.print(fileContents);
                out.flush();
            }
        });

        ListView calllistview = (ListView) findViewById(R.id.calllistview);
       // for (contact each : contacts){
//
      //  }
       // calllistview.setAdapter(new ArrayAdapter<String>(this , R.layout.call_listview , items));
    }
}
