package com.example.captainhumza.fypversion2.Customer.CustomersFragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.captainhumza.fypversion2.Customer.CustomerAdaptor.ProductListAdapter;
import com.example.captainhumza.fypversion2.Customer.CustomerClasses.CountryModel;
import com.example.captainhumza.fypversion2.MapsActivity;
import com.example.captainhumza.fypversion2.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AllProductListFragmentCustomer extends Fragment implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerview;
    private List<CountryModel> mCountryModel;
    private ProductListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.all_product_list_fragment_customer, container, false);

        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);

        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);
        String[] locales = Locale.getISOCountries();
        String[] productName = {"sunsilk" ,"life boy" ,"shan masala" ,"capri" , "prince" ,"saltish","pepsi"};
        String[] productprise = {"200" ,"150" ,"50" ,"45" , "15" ,"85","120"};
        int[] productImage = {R.drawable.sunsilk,R.drawable.sunsilk,R.drawable.sunsilk ,R.drawable.capri,R.drawable.saltish,R.drawable.saltish,R.drawable.pepsi };
        mCountryModel = new ArrayList<>();

        /*for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            mCountryModel.add(new CountryModel(obj.getDisplayCountry(), obj.getISO3Country()));
        }*/
        for(int i = 0; i < productName.length; i++)
        {
            mCountryModel.add(new CountryModel(productName[i], productprise[i] , productImage[i]));
        }

        adapter = new ProductListAdapter(mCountryModel);
        recyclerview.setAdapter(adapter);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        // Do something when collapsed
                        adapter.setFilter(mCountryModel);
                        return true; // Return true to collapse action view
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        // Do something when expanded
                        return true; // Return true to expand action view
                    }
                });
        item = menu.findItem(R.id.action_cart);
        MenuItemCompat.setActionView(item, R.layout.badge1);
        final View cartIcon = menu.findItem(R.id.action_cart).getActionView();
        cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = "hello world";
                //Toast.makeText(this,a,Toast.LENGTH_SHORT).show();
                Intent i = new Intent(v.getContext(), MapsActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<CountryModel> filteredModelList = filter(mCountryModel, newText);
        adapter.setFilter(filteredModelList);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }


    private List<CountryModel> filter(List<CountryModel> models, String query) {
        query = query.toLowerCase();

        final List<CountryModel> filteredModelList = new ArrayList<>();
        for (CountryModel model : models) {
            final String text = model.getName().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}
