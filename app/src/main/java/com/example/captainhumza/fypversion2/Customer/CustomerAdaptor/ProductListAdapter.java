package com.example.captainhumza.fypversion2.Customer.CustomerAdaptor;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.captainhumza.fypversion2.Customer.CustomerClasses.CountryModel;
import com.example.captainhumza.fypversion2.Customer.CustomerViewHolder.DateListViewHolder;
import com.example.captainhumza.fypversion2.Customer.CustomerViewHolder.ProductListViewHolder;
import com.example.captainhumza.fypversion2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Captain Humza on 9/24/2017.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListViewHolder> {
    private List<CountryModel> mCountryModel;
    private List<CountryModel> mOriginalCountryModel;

    public ProductListAdapter(List<CountryModel> mCountryModel) {
        this.mCountryModel = mCountryModel;
        this.mOriginalCountryModel = mCountryModel;
    }

    @Override
    public void onBindViewHolder(final ProductListViewHolder itemViewHolder, int i) {
        final CountryModel model = mCountryModel.get(i);
        itemViewHolder.bind(model);
        itemViewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*MainActivity ma = new MainActivity();
                ma.Print("humza qadeer");*/
                //Toast.makeText(itemViewHolder.view.getContext() ,"hello",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alert = new AlertDialog.Builder(itemViewHolder.view.getContext());
                alert.setTitle(itemViewHolder.name_TextView.getText());
                alert.show();

            }
        });
    }

    @Override
    public ProductListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_product_list_fragment_customer_list, viewGroup, false);
        return new ProductListViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mCountryModel.size();
    }

    public void setFilter(List<CountryModel> countryModels){
        mCountryModel = new ArrayList<>();
        mCountryModel.addAll(countryModels);
        notifyDataSetChanged();
    }
}
