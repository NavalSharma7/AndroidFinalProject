package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pizzeria.datamodel.DataModel;
import com.example.pizzeria.datamodel.OrderInfo;

public class OrderListActivity extends AppCompatActivity implements OrderListAdapter.
        clickItemInterface,
        OrderListAdapter.delteItemInterface {
    private OrderListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        init();
    }

    private void init() {
        RecyclerView orderListView = new RecyclerView(getApplicationContext());
        // set the layout manager
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        orderListView.setLayoutManager(manager);

        //set the adapter
        mAdapter = new OrderListAdapter(getBaseContext(), DataModel.getOrderList());
        orderListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }

    // implement interface methods

    @Override
    public void onClickDelete(OrderInfo info) {
        // dete the item from memory
    }

    @Override
    public void onClickItem(OrderInfo info) {
        // sends the user to Order detail activity

    }
}