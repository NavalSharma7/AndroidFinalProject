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
import java.util.Locale;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderViewHolder> {

    private Context mContext;
    //order list
    private ArrayList<OrderInfo> mOrderList;
    private  deleteListener mDeleteListener;
    private clickItemListener mCLickListener;

    //interface to interact with main activity..
    public interface deleteListener {
        void onClickDelete(OrderInfo info);
    }

    ;

    public interface clickItemListener {
        void onClickItem(OrderInfo info);
    }




    //constructor

    public OrderListAdapter(Context mContext, ArrayList<OrderInfo> mOrderList) {
        this.mContext = mContext;
        this.mOrderList = mOrderList;
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
                mCLickListener.onClickItem(info);
            }
        });

        // click listener for delete button from a order item view
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call interface method for delete item click
                mDeleteListener.onClickDelete(info);
            }
        });
    // set the values to he view of each item from each orderinfo item
        holder.choice1.setText(info.getBreadEnum().getDisplayName());
        holder.choice2.setText(info.getCheeseEnum().getDisplayName());
        holder.choice3.setText(info.getSauceEnum().getDisplayName());
        holder.choice4.setText(info.getToppings().get(0));
        double amount =info.getAmount();
        DecimalFormat precision = new DecimalFormat("0.00");
        holder.amountView.setText(String.format("$ %s",precision.format(amount)));
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
            amountView = itemView.findViewById(R.id.tv_amount);
            dateView = itemView.findViewById(R.id.tv_date);
            deleteButton = itemView.findViewById(R.id.ib_delete);


        }
    }

    public void setOrderList(ArrayList<OrderInfo> orderList){
        this.mOrderList=orderList;
        notifyDataSetChanged();
    }
}
