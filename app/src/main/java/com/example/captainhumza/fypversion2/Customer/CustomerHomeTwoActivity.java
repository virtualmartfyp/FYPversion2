package com.example.captainhumza.fypversion2.Customer;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.captainhumza.fypversion2.Classes.ProductCategory;
import com.example.captainhumza.fypversion2.ContactUs;
import com.example.captainhumza.fypversion2.Customer.CustomersFragments.AllProductListFragmentCustomer;
import com.example.captainhumza.fypversion2.Customer.CustomersFragments.DatesListFragmentCustomer;
import com.example.captainhumza.fypversion2.Customer.CustomersFragments.ExpandableListDirectory.ExpandableListDataPump;
import com.example.captainhumza.fypversion2.Customer.CustomersFragments.ProductListFragmentCustomer;
import com.example.captainhumza.fypversion2.MapsActivity;
import com.example.captainhumza.fypversion2.ProfileDesign;
import com.example.captainhumza.fypversion2.R;
import com.example.captainhumza.fypversion2.ViewPagerAdapter;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class CustomerHomeTwoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , OnMapReadyCallback
        , DatesListFragmentCustomer.OnListFragmentInteractionListener  {
    private static CustomerHomeTwoActivity inst;

     SupportMapFragment map;
   public SupportMapFragment mapFragment;
    public PlaceAutocompleteFragment autocompleteFragment;
    private FragmentManager childFragmentManager;
    private ViewPager viewPager;
    private static android.support.v4.app.Fragment fragment = new MapFragement();

    public static CustomerHomeTwoActivity instance() {
        return inst;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home_two);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        inst = this;
        ProductCategory productCategory = new ProductCategory();
        ExpandableListDataPump.productCategories = productCategory.GetAllProductsCategory();
//            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.popBackStack();
//        fragmentManager.beginTransaction()
//                .add(R.id.content_frame, new MapFragement()).commit();
//
//        MapFragment mapFragment = (MapFragment) getFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager , fragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar,  R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
      autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);


        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Double  lat = place.getLatLng().latitude;
                Double  lng = place.getLatLng().longitude;
                Bundle agrs = new Bundle();
                agrs.putDouble("lat" , lat);
                agrs.putDouble("lng" , lng);
                fragment = new MapFragement(lat , lng);
                setupViewPager(viewPager , fragment);



            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.

            }
        });

    }

    private void setupViewPager(ViewPager viewPager , android.support.v4.app.Fragment fragment) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //adapter.addFragment(new ProductListFragmentCustomer(), "One");
        adapter.addFragment(fragment, "Two");
        //adapter.addFragment(new DatesListFragmentCustomer(), "Three");
        viewPager.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.customer_home_two, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {/*
            Toast.makeText(this,"In Profile",Toast.LENGTH_SHORT).show();
            OrderdList.SetFragment(new DatesListFragmentCustomer());*/
            fragment = new DatesListFragmentCustomer();
            setupViewPager(viewPager , fragment);
            /*Intent intent = new Intent(this , OrderdList.class);
            startActivity(intent);*/
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

            FragmentManager fm = getChildFragmentManager();
            map = (SupportMapFragment) fm.findFragmentById(R.id.map);
            if (map == null) {
                map = SupportMapFragment.newInstance();
                fm.beginTransaction().replace(R.id.map, map).commit();
            }

        } else if (id == R.id.nav_slideshow) {

            fragment = new MapFragement(0.0 , 0.0);
            setupViewPager(viewPager , fragment);
            /*Intent inte = new Intent(this , WalletforCustomer.class);
            startActivity(inte);
*/
        } else if (id == R.id.nav_manage) {

            Intent intent = new Intent(this , ProfileDesign.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(this , ContactUs.class);
            startActivity(intent);
        } else if (id == R.id.nav_marts) {//nav_Home
            fragment = new AllProductListFragmentCustomer();
            setupViewPager(viewPager , fragment);
            /*OrderdList.SetFragment(new  AllProductListFragmentCustomer());
            Intent intent = new Intent(this , OrderdList.class);
            startActivity(intent);*/
        }else if (id == R.id.nav_Home) {//nav_Home
            fragment = new MapFragement();
            setupViewPager(viewPager , fragment);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void genralorder(View view) {
    }

    public FragmentManager getChildFragmentManager() {
        return childFragmentManager;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
/*
        googleMap.addMarker(new MarkerOptions().position(latLng).title("Your Location"));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng , 17));*/

    }

    @Override
    public void onButtonClicked(String mItem) {
        fragment = new ProductListFragmentCustomer();
        setupViewPager(viewPager , fragment);
    }

   /* @Override
    public void onButtonClickedMap(Double  lat, Double  lng){
          fragment = new MapFragement(lat , lng);
          setupViewPager(viewPager , fragment);
        String ab = "new";
    }*/





    /*public void RedirectToProductList(View view) {

    }*/
}
