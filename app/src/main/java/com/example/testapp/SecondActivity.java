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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.String;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String currentkeyword = readfile("Contacts").split("\n")[0];
        TextView msgkeytv = (TextView) findViewById(R.id.msgkeytv);
        msgkeytv.setText(currentkeyword);

        final EditText msgkey = (EditText) findViewById(R.id.msgkey);
        final EditText msgnum = (EditText) findViewById(R.id.msgnum);

        Button msgbtn = (Button) findViewById(R.id.msgbtn);
        Button keychangebtn = (Button) findViewById(R.id.keychangebtn);

        msgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int numstr = Integer.parseInt(msgnum.getText().toString());

                addkey("Contacts" , numstr + "");
            }
        });

        keychangebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keystr = msgkey.getText().toString();

                changekey("Contacts" , keystr);
            }
        });

        ListView msglistview = (ListView) findViewById(R.id.msglistview);
        String[] num_array = readfile("Contacts").split("\n");

        msglistview.setAdapter(new ArrayAdapter<String>(this , R.layout.call_listview , num_array));
    }

    public void addkey(String filename , String num)
    {
        try
        {
            FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE | Context.MODE_APPEND);
            fos.write(num.getBytes());
            fos.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public String readfile(String filename)
    {
        String result = "";

        try
        {
            FileInputStream fis = openFileInput(filename);
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            fis.close();
            result = new String(buffer);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    public void changekey(String filename , String key)
    {
        try {
            String File = readfile(filename);
            FileOutputStream fos = openFileOutput("changes", Context.MODE_PRIVATE);
            String[] Tokens = File.split("\n");

            StringBuilder builder = new StringBuilder();
            int counter = 0;
            for (String s : Tokens) {
                if (counter == 0) {
                    builder.append(key);
                } else {
                    builder.append(s);
                }
                counter = counter + 1;
            }
            String str = builder.toString();
            fos.write(str.getBytes());
            fos.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
