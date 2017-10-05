package com.example.captainhumza.fypversion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class MapPlacePick extends AppCompatActivity {


    int REQUEST_PLACE_PICKER =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_place_pick);
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        Intent intent;
        try {
            intent = builder.build(this);
            startActivityForResult(intent , REQUEST_PLACE_PICKER);
        } catch (GooglePlayServicesRepairableException e)
        {e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_PLACE_PICKER) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                String toast = String.format("Place: %s", place.getName());

//                Bundle args = new Bundle();
//                args.putParcelable("customerLatLng", place.getLatLng());
//                Intent intent=new Intent(this,MapsActivity.class);
//                intent.putExtras(args);
//                startActivity(intent);
                //   Intent intent = new Intent(this,MapsActivity.class);
//                Bundle b = new Bundle();
//                b.putDouble("lat", place.getLatLng().latitude);
//                b.putDouble("long" , place.getLatLng().longitude);
//                intent.putExtras(b);
                //  startActivity(intent);


                Toast.makeText(this , "Your Stored" +place.getName().toString()+ "Added Successfully" , Toast.LENGTH_LONG).show();


            }
        }
    }
}
