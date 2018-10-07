package com.example.mohammadibrahim.test_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText Email;
    EditText Password;
    EditText CPassword;
    EditText Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          final EditText Name =(EditText)findViewById(R.id.name);
          final EditText Email=(EditText)findViewById(R.id.email);
          final EditText Password =(EditText)findViewById(R.id.password);
          final EditText CPassword =(EditText)findViewById(R.id.cpassword);
          final EditText Phone = (EditText)findViewById(R.id.phone);
        Button save =(Button)findViewById(R.id.butR);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                String cpassword = CPassword.getText().toString();
                String phone = Phone.getText().toString();

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("NAME",name);
                intent.putExtra("EMAIL",email);
                intent.putExtra("PASSWORD",password);
                intent.putExtra("RE_PASSWORD",cpassword);
                intent.putExtra("PHONE_NO",phone);
                startActivity(intent);

            }
        });

    }
}
