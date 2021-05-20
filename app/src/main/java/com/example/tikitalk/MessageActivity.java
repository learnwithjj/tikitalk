package com.example.tikitalk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {
    TextView enterPhonenumber,enterMessage;
    Button buttonsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        enterPhonenumber=findViewById(R.id.enterPhonenumber);
        enterMessage=findViewById(R.id.enterMessage);
        buttonsend=findViewById(R.id.buttonsend);

        buttonsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(ContextCompat.checkSelfPermission(MessageActivity.this, Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED)
            {
                sendMessage();
            }
            else
            {
                ActivityCompat.requestPermissions(MessageActivity.this,
                        new String[]{Manifest.permission.SEND_SMS},100);
            }

            }
        });

    }
    private void sendMessage()
    {
        String number=enterPhonenumber.getText().toString().trim();
        String message=enterMessage.getText().toString().trim();
        if(number.isEmpty() )
        {
            Toast.makeText(MessageActivity.this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
        }
        else if(message.isEmpty())
        {
            Toast.makeText(MessageActivity.this, "ENter some text to send", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse( "sms:" + number ) );
            intent.putExtra( "sms_body", message );
            startActivity(intent);
            
        }
    }
}