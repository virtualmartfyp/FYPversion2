package com.example.captainhumza.fypversion2.Customer.CustomerViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.captainhumza.fypversion2.Customer.CustomerClasses.CountryModel;
import com.example.captainhumza.fypversion2.Customer.CustomerClasses.OrderDetails;
import com.example.captainhumza.fypversion2.Customer.OrderdList;
import com.example.captainhumza.fypversion2.R;

/**
 * Created by Captain Humza on 9/24/2017.
 */

public class DateListViewHolder extends RecyclerView.ViewHolder{
    public View view;
    public TextView name_TextView;



    public DateListViewHolder(View itemView) {
        super(itemView);
        itemView.setClickable(true);
        view = itemView;
        name_TextView = (TextView) itemView.findViewById(R.id.dateOfOrders);

    }

    public void bind(OrderDetails countryModel) {
        name_TextView.setText(countryModel.getDate());

    }

}
