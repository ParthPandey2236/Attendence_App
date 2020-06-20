package com.example.attendenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.example.attendenceapp.HOME.p;
import static com.example.attendenceapp.HOME.y;

public class Food extends AppCompatActivity {
    ListView mylist;
    boolean food=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        mylist=(ListView)findViewById(R.id.mylist1);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,y);
        mylist.setAdapter(arrayAdapter);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(food==false){
                    view.setBackgroundColor(Color.GREEN);
                    food=true;
                }
                else{
                    view.setBackgroundColor(Color.WHITE);
                    food=false;
                }
            }
        });
    }
    public void onclick(View view){
        mylist.setAdapter(null);
        y.clear();
    }
}
