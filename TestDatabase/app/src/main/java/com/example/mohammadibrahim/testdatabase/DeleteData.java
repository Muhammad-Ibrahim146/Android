package com.example.mohammadibrahim.testdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteData extends AppCompatActivity {
    DatabseHelper databseHelper;
    EditText editdelete;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);
        databseHelper=new DatabseHelper(this);

        editdelete=(EditText)findViewById(R.id.etdelete);
        delete=(Button)findViewById(R.id.btdelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            databseHelper.deleteData(editdelete.getText().toString());
                Toast.makeText(getApplicationContext(),"Deleted Successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
}
