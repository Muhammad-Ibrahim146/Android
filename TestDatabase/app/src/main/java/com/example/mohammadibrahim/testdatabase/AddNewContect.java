package com.example.mohammadibrahim.testdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewContect extends AppCompatActivity {
    EditText name,mobile_numbre,email;
    Button save;
    private DatabseHelper databseHelper;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contect);
        databseHelper =new DatabseHelper(this);
        name=(EditText)findViewById(R.id.etname);
        mobile_numbre=(EditText)findViewById(R.id.etmobilenumber);
        email=(EditText)findViewById(R.id.etemail);

        save=(Button)findViewById(R.id.btnsave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result= databseHelper.insertdata(name.getText().toString(),Integer.parseInt(mobile_numbre.getText().toString()),email.getText().toString());
                if(result)
                    Toast.makeText(AddNewContect.this,"Data is Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(AddNewContect.this,"Data is not Inserted",Toast.LENGTH_LONG).show();


            }
        });
    }
}
