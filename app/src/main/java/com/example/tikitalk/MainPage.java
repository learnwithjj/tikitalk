package com.example.tikitalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainPage extends AppCompatActivity {
    ImageView imageCall,imageMessage,imageEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        imageCall=findViewById(R.id.imageCall);
        imageMessage=findViewById(R.id.imageMessage);
        imageEmail=findViewById(R.id.imageEmail);


        imageCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainPage.this, com.example.tikitalk.CallActivity.class);
                startActivity(intent);
            }
        });

        imageMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainPage.this, com.example.tikitalk.MessageActivity.class);
                startActivity(intent2);
            }
        });

        imageEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(MainPage.this,com.example.tikitalk.EmailActivity.class);
                startActivity(intent3);
            }
        });

    }
}