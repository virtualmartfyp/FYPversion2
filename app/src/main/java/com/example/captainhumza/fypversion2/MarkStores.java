package com.example.captainhumza.fypversion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.captainhumza.fypversion2.Customer.OrderdList;

import java.util.ArrayList;

public class MarkStores extends AppCompatActivity {

    public   static ListView listView;
    public static ArrayList<String> customers ;
    public static ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_stores);

        listView = (ListView)findViewById(R.id.listview);
        customers  = new ArrayList();
        customers.add("New Customer 1");
        customers.add("New Customer 2");
        customers.add("New Customer 3");
        customers.add("New Customer 4");
        arrayAdapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1 , customers);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {

                Intent intent = new Intent(MarkStores.this, OrderdList.class);

                startActivity(intent);
            }
        });

    }

    public void GoToPlacePick(View view) {


        Intent intent = new Intent(getApplicationContext(), MapPlacePick.class);
        startActivity(intent);
    }
}
