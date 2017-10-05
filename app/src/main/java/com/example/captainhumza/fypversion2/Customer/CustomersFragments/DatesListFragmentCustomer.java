package com.example.captainhumza.fypversion2.Customer.CustomersFragments;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
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

import com.example.captainhumza.fypversion2.Customer.AddToCartActivityCustomer;
import com.example.captainhumza.fypversion2.Customer.CustomerAdaptor.DateListAdapter;
import com.example.captainhumza.fypversion2.Customer.CustomerClasses.OrderDetails;
import com.example.captainhumza.fypversion2.R;

import java.util.ArrayList;
import java.util.List;

public class DatesListFragmentCustomer extends Fragment implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerview;
    private List<OrderDetails> mOrderDetails;
    private DateListAdapter adapter;
    OnListFragmentInteractionListener mListener = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dates_list_fragment_customer, container, false);

        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);

        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);
        mOrderDetails = new ArrayList<>();

        /*for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            mOrderDetails.add(new OrderDetails(obj.getDisplayCountry(), obj.getISO3Country()));
        }*/
        for(int i = 1; i < 20; i++)
        {
            mOrderDetails.add(new OrderDetails(i));
        }

        adapter = new DateListAdapter(mOrderDetails , mListener);
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
                        adapter.setFilter(mOrderDetails);
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
                Intent i = new Intent(v.getContext(), AddToCartActivityCustomer.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<OrderDetails> filteredModelList = filter(mOrderDetails, newText);
        adapter.setFilter(filteredModelList);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }


    private List<OrderDetails> filter(List<OrderDetails> models, String query) {
        query = query.toLowerCase();

        final List<OrderDetails> filteredModelList = new ArrayList<>();
        for (OrderDetails model : models) {
            final String text = model.getDate();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onButtonClicked(String mItem);
    }
}
