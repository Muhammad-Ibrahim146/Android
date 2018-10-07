package com.example.mohammadibrahim.phone_call;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.telephony.SmsManager;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    EditText phone;
    EditText message,web;
    Button button1,browser;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone=(EditText)findViewById(R.id.editText);
        button1=(Button)findViewById(R.id.button1);

        web=(EditText)findViewById(R.id.editText4);
        browser=(Button)findViewById(R.id.button3);
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String websites=web.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://"+ websites+".com"));
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                String number=phone.getText().toString();
                Intent callintent=new Intent(Intent.ACTION_CALL);
                callintent.setData(Uri.parse("tel:"+number));
                startActivity(callintent);
            }
        });
        phone=(EditText)findViewById(R.id.editText) ;
        message=(EditText)findViewById(R.id.editText1);
        send=(Button)findViewById(R.id.button2);
       send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendmessage();

            }
        });
    }
    public void sendmessage(){

       String number=phone.getText().toString();
       String  mess= message.getText().toString();
       if(number==null || number.equals("") || mess==null || mess.equals("")){
           Toast.makeText(this,"Message field can't be Empty!!",Toast.LENGTH_LONG).show();
       }
       else{
           if(TextUtils.isDigitsOnly(number)){
               SmsManager smsManager= SmsManager.getDefault();
               smsManager.sendTextMessage(number,null,mess,null,null);
               Toast.makeText(this,"Message send Successfully!!"+ number,Toast.LENGTH_LONG).show();
           }
           else{
               Toast.makeText(this,"Please Enter Integer Only!!",Toast.LENGTH_LONG).show();
           }
       }
    }

    public void closeApplication(View view) {
        finish();
        moveTaskToBack(true);
    }

    public void clear(View v) {
        phone.getText().clear();
        message.getText().clear();
        web.getText().clear();
    }
}
