package com.example.mohammadibrahim.custom_listview;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int[] IMAGES ={R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g};
    String[] Name={"Rehber","Rehber","Rehber","Rehber","Rehber","Rehber"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView)findViewById(R.id.ListView);
        CustomAdpter customAdpter=new CustomAdpter();
        listView.setAdapter(customAdpter);

    }
    class CustomAdpter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.customlayout, null);
            ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView);
           TextView textView=(TextView)convertView.findViewById(R.id.textView);
            imageView.setImageResource(IMAGES[position]);
            textView.setText(Name[position]);
            return convertView;
        }
    }

}
