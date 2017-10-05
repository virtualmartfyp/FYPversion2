package com.example.captainhumza.fypversion2.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import com.example.captainhumza.fypversion2.ContactUs;
import com.example.captainhumza.fypversion2.Customer.CustomerClasses.OrderDetails;
import com.example.captainhumza.fypversion2.Customer.CustomersFragments.AllProductListFragmentCustomer;
import com.example.captainhumza.fypversion2.Customer.CustomersFragments.DatesListFragmentCustomer;
import com.example.captainhumza.fypversion2.MarkStores;
import com.example.captainhumza.fypversion2.ProfileDesign;
import com.example.captainhumza.fypversion2.R;

public class CustomerHomeTwoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home_two);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

        if (id == R.id.nav_camera) {
            Toast.makeText(this,"In Profile",Toast.LENGTH_SHORT).show();
            OrderdList.SetFragment(new DatesListFragmentCustomer());
            Intent intent = new Intent(this , OrderdList.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

            Intent intent = new Intent(this , MarkStores.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {

            Intent inte = new Intent(this , WalletforCustomer.class);
            startActivity(inte);

        } else if (id == R.id.nav_manage) {

            Intent intent = new Intent(this , ProfileDesign.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(this , ContactUs.class);
            startActivity(intent);
        } else if (id == R.id.nav_marts) {
            OrderdList.SetFragment(new  AllProductListFragmentCustomer());
            Intent intent = new Intent(this , OrderdList.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*public void RedirectToProductList(View view) {

    }*/
}
