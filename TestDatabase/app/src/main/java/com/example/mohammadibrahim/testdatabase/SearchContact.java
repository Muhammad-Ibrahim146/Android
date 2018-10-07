package com.example.mohammadibrahim.testdatabase;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchContact extends AppCompatActivity {

    EditText searchText;
    Button search;
    TextView name;
    TextView email;
    DatabseHelper databseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contact);
        databseHelper=new DatabseHelper(this);

        searchText=(EditText)findViewById(R.id.etSearch);
        name=(TextView)findViewById(R.id.tvname);
        email=(TextView)findViewById(R.id.tvemail);
        search=(Button)findViewById(R.id.btSearch);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor= databseHelper.getData(searchText.getText().toString());

                name.setText(" ");
                email.setText(" ");
                while (cursor.moveToNext()){

                    name.setText(cursor.getString(1));
                    email.setText(cursor.getString(3));
                }

            }
        });
    }
}
