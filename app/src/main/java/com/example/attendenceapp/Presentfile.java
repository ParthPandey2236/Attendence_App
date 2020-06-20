package com.example.attendenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.attendenceapp.HOME.p;

public class Presentfile extends AppCompatActivity {
    ListView mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentfile);
        mylist=(ListView)findViewById(R.id.mylist);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, p) ;


        mylist.setAdapter(arrayAdapter);
    }
    public void onclick(View view){
        mylist.setAdapter(null);
        p.clear();
    }

}

