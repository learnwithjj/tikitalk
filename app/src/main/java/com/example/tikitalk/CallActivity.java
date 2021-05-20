package com.example.tikitalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {
    Button buttoncall,buttonreset;
    TextView displayText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        buttoncall=findViewById(R.id.buttoncall);
        buttonreset=findViewById(R.id.buttonreset);
        displayText=findViewById(R.id.displayText);


        buttoncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=displayText.getText().toString().trim();
                if(number.isEmpty() || number.length()<10 || number.length()!=10)
                {
                    Toast.makeText(CallActivity.this,"Please enter a valid number",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent=new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+number));;
                    startActivity(intent);
                }
            }
        });
        buttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayText.setText(" ");
            }
        });




    }
}