package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pizzeria.datamodel.OrderInfo;

import java.util.ArrayList;

public class OrderDetailsActivity extends AppCompatActivity {


    // private variables

    private OrderInfo mOrderInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        init();
        initListeners();
    }

    private void init(){


        getBundledData();

        // Get ListView object from xml
        ListView listView = (ListView) findViewById(R.id.lv_ingredients);
        // make ingredients string array and set the values from info object
        ArrayList<String> ingredients = getIngredientArray(mOrderInfo);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, ingredients);
        listView.setAdapter(adapter);


    }
    private void initListeners(){

        findViewById(R.id.btn_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to the build pizza activity with orderInfo
                // add the same order and go to orderlist screen
                Intent intent = new Intent(OrderDetailsActivity.this, BuildPizzaActivity .class);

                intent.putExtra("edit_order", mOrderInfo);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_reorder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add the same order and go to orderlist screen
                Intent intent = new Intent(OrderDetailsActivity.this, OrderListActivity.class);

                intent.putExtra("info_obj", mOrderInfo);
                startActivity(intent);

            }
        });

    }

    private ArrayList<String> getIngredientArray(OrderInfo info){
        ArrayList<String> ingredients = new ArrayList<>();

            // set values
        if(info!=null) {
            ingredients.add(info.getBreadEnum());
            ingredients.add(info.getCheeseEnum());
            ingredients.add(info.getSauceEnum());
            ingredients.addAll(info.getToppings());
        }
        return ingredients;
    }
    private void getBundledData(){
        Intent intent = getIntent();
        if (intent == null)
            return;
        OrderInfo info = intent.getParcelableExtra("order_details");
        if (info == null)
            return;
        mOrderInfo = info;

    }
}