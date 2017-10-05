package com.example.captainhumza.fypversion2.Customer.CustomersFragments;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.captainhumza.fypversion2.Customer.CustomerAdaptor.ProductListAdapter;
import com.example.captainhumza.fypversion2.Customer.CustomerClasses.CountryModel;
import com.example.captainhumza.fypversion2.Customer.CustomersFragments.ExpandableListDirectory.CustomExpandableListAdapter;
import com.example.captainhumza.fypversion2.Customer.CustomersFragments.ExpandableListDirectory.ExpandableListDataPump;
import com.example.captainhumza.fypversion2.MapsActivity;
import com.example.captainhumza.fypversion2.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class AllProductListFragmentCustomer extends Fragment implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerview;
    private List<CountryModel> mCountryModel;
    //private ProductListAdapter adapter;

    ExpandableListView expandableListView;
    CustomExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    //CustomExpandableListAdapter adapter;

    private OnFragmentInteractionListener mListener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = LayoutInflater.from(container.getContext()).inflate(R.layout.all_product_list_fragment_customer, container, false);
        expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(view.getContext(), expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(view.getContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(view.getContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        view.getContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });

        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

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

                        expandableListAdapter.setFilter(expandableListTitle);
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
                //  Intent i = new Intent(v.getContext(), MapsActivity.class);
                //startActivity(i);
            }
        });
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<String> filteredModelList = filter(expandableListTitle, newText);
        expandableListAdapter.setFilter(filteredModelList);
        return true;
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }


    private List<String> filter(List<String> models, String query) {
        query = query.toLowerCase();

        final List<String> filteredModelList = new ArrayList<>();
        for (String model : models) {
            final String text = model.toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
