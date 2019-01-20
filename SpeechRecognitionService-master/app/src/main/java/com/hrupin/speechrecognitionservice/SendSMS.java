package com.hrupin.speechrecognitionservice;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import android.content.Intent;

public class SendSMS extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;
    private static String phoneNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkPermission()) {
                Log.e("permission", "Permission already granted.");
            } else {
                requestPermission();
            }
        }

        final String sms = "Help me! I'm in trouble!";

        if(!TextUtils.isEmpty(sms) && !TextUtils.isEmpty(phoneNum)) {
            if(checkPermission()) {

//Get the default SmsManager//

                SmsManager smsManager = SmsManager.getDefault();

//Send the SMS//

                smsManager.sendTextMessage(phoneNum, null, sms, null, null);
            }else {
                Toast.makeText(SendSMS.this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(SendSMS.this, Manifest.permission.SEND_SMS);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PERMISSION_REQUEST_CODE);

    }

    public static void setNumber(String input_number){
        phoneNum = input_number;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(SendSMS.this,
                            "Permission accepted: " + phoneNum, Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(SendSMS.this,
                            "Permission denied", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }
}