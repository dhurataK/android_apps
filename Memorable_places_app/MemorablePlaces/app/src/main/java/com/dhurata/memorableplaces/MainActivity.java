package com.dhurata.memorableplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static ArrayList<String> places_arr;
    static ArrayAdapter arrayAdapter;
    static ArrayList<LatLng> locations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lw = (ListView)findViewById(R.id.places);
        places_arr = new ArrayList<String>();
        places_arr.add("Add a new place...");
        locations = new ArrayList<>();
        locations.add(new LatLng(0,0));

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,places_arr);
        lw.setAdapter(arrayAdapter);
        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                intent.putExtra("locationInfo",position);
                startActivity(intent);
            }
        });
    }
}
