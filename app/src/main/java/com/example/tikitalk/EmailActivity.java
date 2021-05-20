package com.example.tikitalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.security.auth.Subject;

public class EmailActivity extends AppCompatActivity {

    TextView subjectText,toText,bodyText;
    Button buttonsendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        subjectText=findViewById(R.id.subjectText);
        toText=findViewById(R.id.toText);
        bodyText=findViewById(R.id.bodyText);
        buttonsendEmail=findViewById(R.id.buttonsendEmail);

        buttonsendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to=toText.getText().toString().trim();
                String subject=subjectText.getText().toString().trim();
                String body=bodyText.getText().toString().trim();
                if(to.isEmpty() || subject.isEmpty() || body.isEmpty())
                {
                    Toast.makeText(EmailActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent=new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                    intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                    intent.putExtra(Intent.EXTRA_TEXT,body);
                    intent.setType("message/rfc822");
                    startActivity(Intent.createChooser(intent,"send mail"));

                }
            }
        });

    }
}