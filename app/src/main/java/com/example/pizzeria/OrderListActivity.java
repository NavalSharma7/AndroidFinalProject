package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pizzeria.datamodel.DataModel;
import com.example.pizzeria.datamodel.OrderInfo;

public class OrderListActivity extends AppCompatActivity implements OrderListAdapter.
        clickItemListener,
        OrderListAdapter.deleteListener {
    // global adapter variable as the view would be needed to updated from diffrent functions.
    private OrderListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        init();
    }

    private void init() {
        RecyclerView orderListView = new RecyclerView(this);
        orderListView = findViewById(R.id.rv_order_list);
        //set the adapter
        mAdapter = new OrderListAdapter(this, DataModel.getOrderList());

        orderListView.setAdapter(mAdapter);
        // mAdapter.setOrderList(DataModel.getOrderList());
        mAdapter.notifyDataSetChanged();

    }

    // implement interface methods

    @Override
    public void onClickDelete(OrderInfo info) {
        //match id and delete the item from memory

        // delete the item from recycler view and refresh..
    }

    @Override
    public void onClickItem(OrderInfo info) {
        // sends the user to Order detail activity

    }
}