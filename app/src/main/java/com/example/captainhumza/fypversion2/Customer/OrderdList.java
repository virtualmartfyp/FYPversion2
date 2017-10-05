package com.example.captainhumza.fypversion2.Customer;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


import com.example.captainhumza.fypversion2.Customer.CustomersFragments.AllProductListFragmentCustomer;
import com.example.captainhumza.fypversion2.Customer.CustomersFragments.DatesListFragmentCustomer;
import com.example.captainhumza.fypversion2.Customer.CustomersFragments.ProductListFragmentCustomer;
import com.example.captainhumza.fypversion2.R;
import com.example.captainhumza.fypversion2.ViewPagerAdapter;
import com.example.captainhumza.fypversion2.Customer.CustomersFragments.DatesListFragmentCustomer.OnListFragmentInteractionListener;

public class OrderdList extends AppCompatActivity implements OnListFragmentInteractionListener{

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private static   Fragment fragment = new DatesListFragmentCustomer();
    public static void SetFragment(Fragment _fragment)
    {
        fragment = _fragment;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderd_list);

       /*toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        ActionBar actionBar = getSupportActionBar();

       actionBar.setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager , fragment);
        //setupViewPager(viewPager , new DatesListFragmentCustomer());
       // setupViewPager(viewPager , new ProductListFragmentCustomer());
   /*     tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);*/
    }

    private void setupViewPager(ViewPager viewPager , Fragment fragment) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //adapter.addFragment(new ProductListFragmentCustomer(), "One");
        adapter.addFragment(fragment, "Two");
        //adapter.addFragment(new DatesListFragmentCustomer(), "Three");
        viewPager.setAdapter(adapter);

    }

    @Override
    public void onButtonClicked(String mItem) {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager , new ProductListFragmentCustomer());
        Toast.makeText(this,mItem , Toast.LENGTH_SHORT).show();
    }
}
