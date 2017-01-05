package com.dhurata.memorableplaces;

import android.app.ActionBar;
import android.content.Intent;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.gms.identity.intents.Address;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;
    int location = -1;

    @Override
    public void onMapLongClick(LatLng point) {
        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
        String label = new Date().toString();
        try {
            List<android.location.Address> addressList = geocoder.getFromLocation(point.latitude, point.longitude,1);

            if(addressList != null && addressList.size()>0){
                label = addressList.get(0).getAddressLine(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        MainActivity.places_arr.add(label);
        MainActivity.arrayAdapter.notifyDataSetChanged();
        MainActivity.locations.add(point);
        mMap.addMarker(new MarkerOptions()
                .position(point)
                .title(label)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        ActionBar actionBar = getActionBar();
//
//        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        location = intent.getIntExtra("locationInfo",-1);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                // app icon in action bar clicked; goto parent activity.
//                this.finish();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if(location != -1 && location != 0){
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(MainActivity.locations.get(location), 10));
        mMap.addMarker(new MarkerOptions().position(MainActivity.locations.get(location)).title(MainActivity.places_arr.get(location)));
        }
        mMap.setOnMapLongClickListener(this);
    }
}
