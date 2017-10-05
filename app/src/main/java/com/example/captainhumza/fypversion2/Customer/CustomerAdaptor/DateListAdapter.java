package com.example.captainhumza.fypversion2.Customer.CustomerAdaptor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.captainhumza.fypversion2.Customer.CustomerClasses.OrderDetails;
import com.example.captainhumza.fypversion2.Customer.CustomerViewHolder.DateListViewHolder;
import com.example.captainhumza.fypversion2.Customer.CustomersFragments.DatesListFragmentCustomer.OnListFragmentInteractionListener;
import com.example.captainhumza.fypversion2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Captain Humza on 9/24/2017.
 */

public class DateListAdapter extends RecyclerView.Adapter<DateListViewHolder> {
    private List<OrderDetails> mOrderDetails;
    private List<OrderDetails> mOriginalOrderDetails;
    private OnListFragmentInteractionListener mListener;

    public DateListAdapter(List<OrderDetails> mOrderDetails , OnListFragmentInteractionListener listener) {
        this.mOrderDetails = mOrderDetails;
        this.mOriginalOrderDetails = mOrderDetails;
        mListener = listener;
    }

    @Override
    public void onBindViewHolder(final DateListViewHolder itemViewHolder, int i) {
        final OrderDetails model = mOrderDetails.get(i);
        itemViewHolder.bind(model);
        itemViewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onButtonClicked(itemViewHolder.name_TextView.getText().toString());
                /*OrderdList ma = new OrderdList();
                ma.Print();*/
               //Toast.makeText(itemViewHolder.view.getContext() ,"hello",Toast.LENGTH_SHORT).show();
                /*AlertDialog.Builder alert = new AlertDialog.Builder(itemViewHolder.view.getContext());
                alert.setTitle(itemViewHolder.name_TextView.getText());
                alert.show();*/

            }
        });
    }

    @Override
    public DateListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dates_list_fragment_customer_list, viewGroup, false);
        return new DateListViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mOrderDetails.size();
    }

    public void setFilter(List<OrderDetails> OrderDetailss){
        mOrderDetails = new ArrayList<>();
        mOrderDetails.addAll(OrderDetailss);
        notifyDataSetChanged();
    }

}
