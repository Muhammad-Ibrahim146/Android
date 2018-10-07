package com.example.mohammadibrahim.test;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

     EditText femail;
     EditText fpass;
     Button fsend;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        femail=(EditText)findViewById(R.id.ed1);
        fpass=(EditText)findViewById(R.id.ed2);
        fsend=(Button)findViewById(R.id.btn1);

        fsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=femail.getText().toString();
                String password=fpass.getText().toString();

                Register(mail,password);
            }
        });


    }

    private void Register(String mail, String password) {

        mAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
