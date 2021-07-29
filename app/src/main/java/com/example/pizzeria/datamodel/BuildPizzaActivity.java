
package com.example.pizzeria.datamodel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeria.OrderListActivity;
import com.example.pizzeria.R;

public class BuildPizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_pizza);
        init();
        initListeners();
    }
    private void init(){

    }

    private void initListeners(){
        findViewById(R.id.btn_order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuildPizzaActivity.this, OrderListActivity.class);
                startActivity(intent);
            }
        });
    }

}