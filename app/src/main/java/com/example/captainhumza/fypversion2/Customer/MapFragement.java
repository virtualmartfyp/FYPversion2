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
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
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
    Double  lat = 24.823741700000003;
    Double  lng = 67.11515829999999;
    OnMapClickListner listner;
    View vCus;
    public MapFragement() {
        // Required empty public constructor
    }
    public MapFragement(Double  lat, Double  lng) {
        this.lat = lat;
        this.lng = lng;
    }

Context mycon ;
    public PlaceAutocompleteFragment autocompleteFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

  View v=  inflater.inflate(R.layout.fragment_map_fragement, container, false);
        mycon = v.getContext();
       //autocompleteFragment  = (PlaceAutocompleteFragment)getActivity().getFragmentManager()findViewById(R.place_autocomplete_fragment);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        /*autocompleteFragment  = (PlaceAutocompleteFragment)getActivity().getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Double  lat = place.getLatLng().latitude;
                Double  lng = place.getLatLng().longitude;
                Bundle agrs = new Bundle();
                agrs.putDouble("lat" , lat);
                agrs.putDouble("lng" , lng);
                //listner.onButtonClickedMap(lat , lng);

            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.

            }
        });*/



    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        //LatLng ltlng = new LatLng(0 , 0);
        /*mMap.addMarker(new MarkerOptions().position(latLng).title("Your Current Location"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom( ltlng , 15));
//*/
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
   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnMapClickListner) {

            listner = (OnMapClickListner) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }*/
    public interface OnMapClickListner {
        // TODO: Update argument type and name
        void onButtonClickedMap(Double  lat, Double  lng);
    }

}
