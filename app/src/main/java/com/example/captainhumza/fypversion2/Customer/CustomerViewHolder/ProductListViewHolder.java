package com.example.captainhumza.fypversion2.Customer.CustomerViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.captainhumza.fypversion2.Customer.CustomerClasses.CountryModel;
import com.example.captainhumza.fypversion2.R;

/**
 * Created by Captain Humza on 9/24/2017.
 */

public class ProductListViewHolder extends RecyclerView.ViewHolder {
    public View view;
    public TextView name_TextView;
    public TextView iso_TextView;
    public ImageView producImageView;



    public ProductListViewHolder(View itemView) {
        super(itemView);
        itemView.setClickable(true);
        view = itemView;
        name_TextView = (TextView) itemView.findViewById(R.id.from_name);
        iso_TextView = (TextView) itemView.findViewById(R.id.plist_price_text);
        producImageView = (ImageView) itemView.findViewById(R.id.list_image);

    }

    public void bind(CountryModel countryModel) {
        name_TextView.setText(countryModel.getName());
        iso_TextView.setText(countryModel.getisoCode());
        //String s = "@drawable/pepsi";
        //int a = R.drawable.sunsilk;
        producImageView.setImageResource(countryModel.getImageCode());

    }
}
