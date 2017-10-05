package com.example.captainhumza.fypversion2.Customer;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.captainhumza.fypversion2.Customer.CustomersFragments.CustomerProdustsOrderdList;
import com.example.captainhumza.fypversion2.Customer.CustomersFragments.DatesListFragmentCustomer;
import com.example.captainhumza.fypversion2.R;
import com.example.captainhumza.fypversion2.ViewPagerAdapter;

public class AddToCartActivityCustomer extends AppCompatActivity {

    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart_customer);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager , new CustomerProdustsOrderdList());
    }
    private void setupViewPager(ViewPager viewPager , Fragment fragment) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //adapter.addFragment(new ProductListFragmentCustomer(), "One");
        adapter.addFragment(fragment, "Two");
        //adapter.addFragment(new DatesListFragmentCustomer(), "Three");
        viewPager.setAdapter(adapter);

    }
}
