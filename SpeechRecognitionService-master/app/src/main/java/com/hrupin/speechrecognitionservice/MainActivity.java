package com.hrupin.speechrecognitionservice;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private final static int REQUEST_CODE_1 = 1;
    private static final int PERMISSIONS_REQUEST_RECORD_AUDIO = 1;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private static String number = "6478192180";
    private static String keyphrase = "lavatory";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button callsetbtn = (Button) findViewById(R.id.callsetbtn);
        callsetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent( getApplicationContext() , ThirdScreen.class);
                startActivity(startIntent);
            }
        });
        String filename = "Contacts";

        Button msgsetbtn = (Button) findViewById(R.id.msgsetbtn);
        msgsetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SecondScreen.class);
                startActivity(startIntent);
            }
        });

        Switch switchToggle = (Switch) findViewById(R.id.switchToggle);

        switchToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Intent componentName = (new Intent(MainActivity.this, VoiceService.class));
            componentName.putExtra("keyword", keyphrase.toString());
            if(isChecked)
            {
                Log.i(LOG_TAG, "onClick");
                int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO);
                if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.RECORD_AUDIO}, PERMISSIONS_REQUEST_RECORD_AUDIO);
                    return;
                }
                //SendSMS.setNumber(number);

                startService(componentName);
            }
            else
            {
                stopService(componentName);
            }
        }
        });
    }
    /*
    // This method is invoked when target activity return result data back.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dataIntent) {
        super.onActivityResult(requestCode, resultCode, dataIntent);

        // The returned result data is identified by requestCode.
        // The request code is specified in startActivityForResult(intent, REQUEST_CODE_1); method.
        switch (requestCode)
        {
            // This request code is set by startActivityForResult(intent, REQUEST_CODE_1) method.
            case REQUEST_CODE_1:
                if(resultCode == RESULT_OK)
                {
                    String messageReturn = dataIntent.getStringExtra("message_return");
                }
        }
    }
    */
    public void launchSMS(View view) {
        Intent intent = new Intent(MainActivity.this, SendSMS.class);
        startActivity(intent);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSIONS_REQUEST_RECORD_AUDIO) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startService(new Intent(MainActivity.this, VoiceService.class));
            } else {
                finish();
            }
        }
    }
}
