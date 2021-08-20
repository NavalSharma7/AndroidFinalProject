package com.example.pizzeria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzeria.datamodel.OrderInfo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderViewHolder> {

    private Context mContext;
    //order list
    private List<OrderInfo> mOrderList;

    private clickItemListener mCLickListener;
    private deleteListener mDeleteListener;

    public Context getContext() {
        return this.mContext;
    }

    //interface to interact with main activity..

    public interface clickItemListener {
        void onClickItem(OrderInfo info);
    }

    public interface deleteListener {
        void onDeleteItem(OrderInfo info);
    }

    //constructor

    public OrderListAdapter(Context mContext, clickItemListener clickItemListener, deleteListener deleteListener) {
        this.mContext = mContext;
        this.mCLickListener = clickItemListener;
        this.mDeleteListener = deleteListener;
        notifyDataSetChanged();
    }


    @Override
    public OrderListAdapter.OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // Inflate the layout view you have created for the list rows here
        View view = layoutInflater.inflate(R.layout.view_item_order_list, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderListAdapter.OrderViewHolder holder, int position) {
        OrderInfo info = mOrderList.get(position);
        if (info == null)
            return;

        //click listener for full item of the list
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call interface method for item view click
                if (mCLickListener != null)
                    mCLickListener.onClickItem(info);
            }
        });


        // set the values to he view of each item from each orderinfo item
        holder.choice1.setText(info.getBreadEnum());
        holder.choice2.setText(info.getCheeseEnum());
        holder.choice3.setText(info.getSauceEnum());
        if (info.getToppings() != null)
            holder.choice4.setText(info.getToppings().get(0));
        holder.dateView.setText(info.getOrderDate());

    }

    @Override
    public int getItemCount() {
        return mOrderList == null ? 0 : mOrderList.size();
    }
    // View holder class

    public class OrderViewHolder extends RecyclerView.ViewHolder {

        TextView choice1, choice2, choice3, choice4, amountView, dateView;
        ImageButton deleteButton;
        CardView cardView;

        public OrderViewHolder(View itemView) {
            super(itemView);
            // initialize your views in 1 order item
            cardView = itemView.findViewById(R.id.parent_view_adapter_item);
            choice1 = itemView.findViewById(R.id.tv_choice1);
            choice2 = itemView.findViewById(R.id.tv_choice2);
            choice3 = itemView.findViewById(R.id.tv_choice3);
            choice4 = itemView.findViewById(R.id.tv_choice4);
            dateView = itemView.findViewById(R.id.tv_date);


        }
    }

    public void setOrderList(List<OrderInfo> orderList) {
        this.mOrderList = orderList;
        notifyDataSetChanged();
    }

    // public methods
    public void deleteItem(int position) {
        if (mDeleteListener != null)
            mDeleteListener.onDeleteItem(mOrderList.get(position));
//        mOrderList.remove(position);
//        notifyItemRemoved(position);


    }


}
