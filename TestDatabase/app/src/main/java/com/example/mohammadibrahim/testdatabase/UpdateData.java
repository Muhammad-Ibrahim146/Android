package com.example.mohammadibrahim.testdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateData extends AppCompatActivity {
    DatabseHelper databseHelper;
    EditText namebutton,phonebutton,emailbutton;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        databseHelper = new DatabseHelper(this);

        namebutton=(EditText)findViewById(R.id.etupdatename);
        phonebutton=(EditText) findViewById(R.id.etupdatephone);
        emailbutton=(EditText) findViewById(R.id.etupdatemail);
        update=(Button) findViewById(R.id.btupdate);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databseHelper.updateData(phonebutton.getText().toString(),namebutton.getText().toString(),emailbutton.getText().toString());
               Toast.makeText(getApplicationContext(),"Updated Successfully",Toast.LENGTH_LONG).show();

            }
        });
    }
}
