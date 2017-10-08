package com.example.captainhumza.fypversion2.Customer;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;

import com.example.captainhumza.fypversion2.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragement extends Fragment implements  OnMapReadyCallback {

    GoogleMap mMap;
  LatLng latLng;
    Double  lat = 0.0;
    Double  lng = 0.0;
    public MapFragement() {
        // Required empty public constructor
    }
    public MapFragement(Double  lat, Double  lng) {
        this.lat = lat;
        this.lng = lng;
    }
Context mycon ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
 View v=  inflater.inflate(R.layout.fragment_map_fragement, container, false);
        mycon = v.getContext();
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        //LatLng ltlng = new LatLng(0 , 0);
        /*mMap.addMarker(new MarkerOptions().position(latLng).title("Your Current Location"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom( ltlng , 15));*/
//
//        Bundle getBundle =  getArguments();
//        Double lat = getBundle.getDouble("lat");
//        Double lng = getBundle.getDouble("lng");
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(lat , lng);
//
//
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom( new LatLng (lat , lng) , 15));
        mMap.addMarker(new MarkerOptions().position(sydney).title("Your Selected Location "));

    }


}
