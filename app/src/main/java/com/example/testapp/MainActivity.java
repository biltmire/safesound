package com.example.testapp;

import android.content.Intent;
// import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
// import android.content.pm.PackageManager;



public class MainActivity extends AppCompatActivity {
    static List<String> numbers = new ArrayList<>();
    static String filename = "Contacts.txt";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button callsetbtn = (Button) findViewById(R.id.callsetbtn);
        callsetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent( getApplicationContext() , SecondActivity.class);
                startActivity(startIntent);
            }
        });String filename = "Contacts.txt";

        Button msgsetbtn = (Button) findViewById(R.id.msgsetbtn);
        callsetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(startIntent);
            }
        });

        Switch switchToggle = (Switch) findViewById(R.id.switchToggle);

        switchToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    // Do something
                }
                else
                {

                }
            }
        });
    }

    protected int loadContacts()
    {
        try
        {
            String line = null;
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null)
            {
                if (line.trim().length()==0) continue;	//skips empty line
                numbers.add(line);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers.size();
    }
}
