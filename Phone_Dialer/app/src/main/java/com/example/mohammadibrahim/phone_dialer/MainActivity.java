package com.example.mohammadibrahim.phone_dialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnone;
    Button btntwo;
    Button btnthree;
    Button btnfour;
    Button btnfive;
    Button btnsix;
    Button btnseven;
    Button btneight;
    Button btnnine;
    Button btnstar;
    Button btnzero;
    Button btnhashaTag;
    Button btnDelete;
    Button btnDial;
    EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnone = (Button) findViewById(R.id.buttonone);
        Button btntwo = (Button) findViewById(R.id.buttontwo);
        Button btnthree = (Button) findViewById(R.id.buttonthree);
        Button btnfour = (Button) findViewById(R.id.buttonfour);
        Button btnfive = (Button) findViewById(R.id.buttonfive);
        Button btnsix = (Button) findViewById(R.id.buttonsix);
        Button btnseven = (Button) findViewById(R.id.buttonseven);
        Button btneight = (Button) findViewById(R.id.buttoneight);
        Button btnnine = (Button) findViewById(R.id.buttonnine);
        Button btnstar = (Button) findViewById(R.id.buttonstar);
        Button btnhashTag = (Button) findViewById(R.id.buttonhash);
        Button btnDelete = (Button) findViewById(R.id.buttondelete);
        Button btnDial = (Button) findViewById(R.id.buttondial);

        input = (EditText) findViewById(R.id.editText);

    }

    public void one(View v) {
        onButtonClick(btnone, input, "1");

    }

    public void two(View v) {
        onButtonClick(btntwo, input, "2");

    }

    public void three(View v) {
        onButtonClick(btnthree, input, "3");

    }

    public void four(View v) {
        onButtonClick(btnfour, input, "4");

    }

    public void five(View v) {
        onButtonClick(btnfive, input, "5");

    }

    public void six(View v) {
        onButtonClick(btnsix, input, "6");

    }

    public void seven(View v) {
        onButtonClick(btnseven, input, "7");

    }

    public void eight(View v) {
        onButtonClick(btneight, input, "8");

    }

    public void nine(View v) {
        onButtonClick(btnnine, input, "9");


    }

    public void star(View v) {
        onButtonClick(btnstar, input, "*");

    }

    public void zero(View v) {
        onButtonClick(btnzero, input, "0");

    }

    public void hashTag(View v) {
        onButtonClick(btnhashaTag, input, "#");

    }

    public void onDelete(View v) {
        input.setText("");

    }

    public void dial(View v) {
        String number = input.getText().toString();
        if (input.getText().length() <= 3) {
            Toast.makeText(this, "Please Enter Valid Number" , Toast.LENGTH_LONG).show();

        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            String hashTag = input.getText().toString();
            if (hashTag.contains("#")) {
                hashTag.replace("#", "#23");

            }
            intent.setData(Uri.parse("Tel:" + hashTag ));

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                return ;
            }else {
                intent.setData(Uri.parse("Tel:" + number));
                startActivity(intent);
            }

        }

    }
    public void onButtonClick(Button button,EditText inputNumber,String number){
        String cache= input.getText().toString();
        inputNumber.setText(cache+number);
    }


}
