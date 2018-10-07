package com.example.mohammadibrahim.testdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button insert;
    Button searchbutton;
    Button deletebutton;
    Button updatebutton;
    DatabseHelper databseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            databseHelper=new DatabseHelper(this);
            insert=(Button)findViewById(R.id.btnadd);
            insert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,AddNewContect.class);
                    startActivity(intent);
                }
            });
            searchbutton=(Button)findViewById(R.id.btnsearch);
            searchbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(MainActivity.this,SearchContact.class);
                    startActivity(intent);
                }
            });
            deletebutton=(Button)findViewById(R.id.btndelete);
            deletebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(MainActivity.this,DeleteData.class);
                    startActivity(intent);
                }
            });

            updatebutton=(Button)findViewById(R.id.btnupdate);

            updatebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(MainActivity.this,UpdateData.class);
                    startActivity(intent);
                }
            });

    }
}
