package com.example.pizzeria;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.pizzeria.datamodel.DataModel;
import com.example.pizzeria.datamodel.OrderInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class OrderListActivity extends AppCompatActivity  {
    // global adapter variable as the view would be needed to updated from diffrent functions.
    private OrderListAdapter mAdapter;
    private List<OrderInfo> mOrders;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        // load the last data from shared preferences
        loadData();

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                OrderInfo info = intent.getParcelableExtra("info_obj");
                if (info != null) {
                    // add values / save order
                    mOrders.add(info);
                    // save the list in prefs
                    saveData();

                }
            }
        }
        init();

    }

    private void init() {
        RecyclerView orderListView = new RecyclerView(this);
        orderListView = findViewById(R.id.rv_order_list);
        //set the adapter
        mAdapter = new OrderListAdapter(this, new OrderListAdapter.clickItemListener() {
            @Override
            public void onClickItem(OrderInfo info) {
                // go to the Order details activity with orderInfo

                Intent intent = new Intent(OrderListActivity.this, OrderDetailsActivity .class);

                intent.putExtra("order_details", info);
                startActivity(intent);
            }
        }, new OrderListAdapter.deleteListener() {
            @Override
            public void onDeleteItem(OrderInfo info) {
                //remove from list and save in shared preferences
                mOrders.remove(info);
                saveData();
                mAdapter.setOrderList(mOrders);
            }
        });


        orderListView.setAdapter(mAdapter);


        ItemTouchHelper itemTouchHelper = new
                ItemTouchHelper(new SwipeToDeleteCallback(mAdapter));
        itemTouchHelper.attachToRecyclerView(orderListView);
        mAdapter.setOrderList(mOrders);
        mAdapter.notifyDataSetChanged();

    }



    // shared preferences methods
    private void loadData() {
        // method to load arraylist from shared prefs
        // initializing our shared prefs with name as
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);

        // creating a variable for gson.
        Gson gson = new Gson();

        // below line is to get to string present from our
        // shared prefs if not present setting it as null.
        String json = sharedPreferences.getString("orders", null);

        // below line is to get the type of our array list.
        Type type = new TypeToken<List<OrderInfo>>() {
        }.getType();

        // in below line we are getting data from gson
        // and saving it to our array list
        mOrders = gson.fromJson(json, type);

        // checking below if the array list is empty or not
        if (mOrders == null) {
            // if the array list is empty
            // creating a new array list.
            mOrders = new ArrayList<>();
        }
    }

    private void saveData() {
        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // creating a new variable for gson.
        Gson gson = new Gson();


        // getting data from gson and storing it in a string.
        String json = gson.toJson(mOrders);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("orders", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();

    }

    private void clearData() {

        // get the default list from data model and change the list as it will remove any ctsom added dices
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();


        // getting data from gson and storing it in a string.
        String json = gson.toJson(mOrders);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("orders", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}