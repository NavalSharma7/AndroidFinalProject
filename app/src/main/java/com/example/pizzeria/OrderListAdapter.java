package com.example.pizzeria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzeria.datamodel.OrderInfo;

import java.util.ArrayList;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderViewHolder> {

    private Context mContext;
    //order list
    private ArrayList<OrderInfo> mOrderList;

    //interface to interact with main activity..
    public interface delteItemInterface{
        void onClickDelete(OrderInfo info);
    };
    public  interface  clickItemInterface{
        void onClickItem(OrderInfo info);
    };


    //constructor

    public OrderListAdapter(Context mContext, ArrayList<OrderInfo> mOrderList) {
        this.mContext = mContext;
        this.mOrderList = mOrderList;
    }

    @Override
    public OrderListAdapter.OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // Inflate the layout view you have created for the list rows here
        View view = layoutInflater.inflate(R.layout.view_item_order_list, parent, false);
        return new OrderViewHolder (view);
    }

    @Override
    public void onBindViewHolder(OrderListAdapter.OrderViewHolder holder, int position) {
            OrderInfo info = mOrderList.get(position);

    }

    @Override
    public int getItemCount() {
        return mOrderList == null? 0: mOrderList.size();
    }
    // View holder class

    public class OrderViewHolder extends RecyclerView.ViewHolder{

        public OrderViewHolder(View itemView) {
            super(itemView);
            // initialize your views in 1 order item

        }
    }
}
