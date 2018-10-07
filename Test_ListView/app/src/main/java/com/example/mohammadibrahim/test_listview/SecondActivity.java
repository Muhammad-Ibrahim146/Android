package com.example.mohammadibrahim.test_listview;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    String Name;
    String Email;
    String Password;
    String CPassword;
    String Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Name = getIntent().getExtras().getString("NAME");
        Email = getIntent().getExtras().getString("EMAIL");
        Password = getIntent().getExtras().getString("PASSWORD");
        CPassword = getIntent().getExtras().getString("CPASSWORD");
        Phone = getIntent().getExtras().getString("PHONE_NO");

        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Name:" + Name + '\n' + "Email:" + Email + '\n' + "Phone" + Phone);


            ImageView imagecall=(ImageView)findViewById(R.id.call);
            imagecall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    Phone=textView.getText().toString();
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("tel:" + Phone));
                    if (ActivityCompat.checkSelfPermission(SecondActivity.this,Manifest.permission.CALL_PHONE)!=
                    PackageManager.PERMISSION_GRANTED){}

                   startActivity(intent);
                }
            });

      }
}