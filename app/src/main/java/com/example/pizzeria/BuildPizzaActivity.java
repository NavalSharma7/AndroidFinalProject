
package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.pizzeria.datamodel.BaseSauceEnum;
import com.example.pizzeria.datamodel.BreadEnum;
import com.example.pizzeria.datamodel.CheeseEnum;
import com.example.pizzeria.datamodel.OrderInfo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BuildPizzaActivity extends AppCompatActivity {


    private RadioGroup breadGroup;
    private RadioGroup cheeseGroup;
    private RadioGroup sauceGroup;
    private RadioButton chickenBtn;
    private RadioButton beefBtn;
    private RadioButton pepperoniBtn;
    private RadioButton onionBtn;
    private RadioButton mushroomBtn;
    private RadioButton jalapenoBtn;
    private RadioButton capsicumBtn;
    private RadioButton tomatoBtn;
    private RadioButton extraCheeseBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_pizza);
        init();
        initListeners();
        // get extra and set values from details screen
        getExtras();
    }

    private void init() {
        breadGroup = findViewById(R.id.rg_bread);
        cheeseGroup = findViewById(R.id.rg_cheese);
        sauceGroup = findViewById(R.id.rg_sauce);
        chickenBtn = findViewById(R.id.rb_chicken);
        beefBtn = findViewById(R.id.rb_beef);
        pepperoniBtn = findViewById(R.id.rb_pepperoni);
        capsicumBtn = findViewById(R.id.rb_capsicum);
        tomatoBtn = findViewById(R.id.rb_tomato);
        mushroomBtn = findViewById(R.id.rb_mushroom);
        jalapenoBtn = findViewById(R.id.rb_jellapeno);
        extraCheeseBtn = findViewById(R.id.rb_extra_cheese);
        onionBtn = findViewById(R.id.rb_onion);

    }

    private void initListeners() {
        findViewById(R.id.btn_order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuildPizzaActivity.this, OrderListActivity.class);
                OrderInfo info = getOrderInfo();
                intent.putExtra("info_obj", info);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
    }

    private void getExtras() {
        Intent intent = getIntent();
        if (intent == null)
            return;
        OrderInfo info = intent.getParcelableExtra("edit_order");
        if (info == null)
            return;
        setInfoValues(info);
    }

    private void setInfoValues(OrderInfo info) {
        String bread = info.getBreadEnum();

        if (bread.equals(BreadEnum.REGULAR.getDisplayName())) {
            breadGroup.check(R.id.rb_Regular);
        } else if (bread.equals(BreadEnum.THICK_CRUST.getDisplayName())) {
            breadGroup.check(R.id.rb_thick_crust);
        } else if (bread.equals(BreadEnum.THIN_CRUST.getDisplayName())) {
            breadGroup.check(R.id.rb_thin_crust);
        }

        String cheese = info.getCheeseEnum();
        if (cheese.equals(CheeseEnum.CHEDDAR.getDisplayName())) {
            cheeseGroup.check(R.id.rb_cheddar);
        } else if (cheese.equals(CheeseEnum.PARMESAN.getDisplayName())) {
            cheeseGroup.check(R.id.rb_Parmesan);
        } else if (cheese.equals(CheeseEnum.NO_CHEESE.getDisplayName())) {
            cheeseGroup.check(R.id.rb_no_cheese);
        } else if (cheese.equals(CheeseEnum.MOZZARELLA.getDisplayName())) {
            cheeseGroup.check(R.id.rb_mozzarella);
        }

        String sauce = info.getSauceEnum();
        if (sauce.equals(BaseSauceEnum.BBQ.getDisplayName())) {
            cheeseGroup.check(R.id.rb_bbq);
        } else if (sauce.equals(BaseSauceEnum.CREAMY_GARLIC.getDisplayName())) {
            cheeseGroup.check(R.id.rb_creamy_garlic);
        } else if (sauce.equals(BaseSauceEnum.ITALIAN_TOMATO.getDisplayName())) {
            cheeseGroup.check(R.id.rb_italian_tomato);
        } else if (sauce.equals(BaseSauceEnum.PESTO.getDisplayName())) {
            cheeseGroup.check(R.id.rb_pesto);
        }


        List<String> toppings = info.getToppings();
        if (toppings.isEmpty())
            return;
        for (String topping : toppings) {
            if (topping.equals("Chicken"))
                chickenBtn.setChecked(true);
            else if (topping.equals("Beef"))
                beefBtn.setChecked(true);
            else if (topping.equals("Pepperoni"))
                pepperoniBtn.setChecked(true);
            else if (topping.equals("Capsicum"))
                capsicumBtn.setChecked(true);
            else if (topping.equals("Extra Cheese"))
                extraCheeseBtn.setChecked(true);
            else if (topping.equals("Tomato"))
                tomatoBtn.setChecked(true);
            else if (topping.equals("Onion"))
                onionBtn.setChecked(true);
            else if (topping.equals("Jellapeno"))
                jalapenoBtn.setChecked(true);
            else if (topping.equals("Mushroom"))
                mushroomBtn.setChecked(true);
        }

    }

    private OrderInfo getOrderInfo() {

        // get the current choices from the UI and set in info object

        OrderInfo info = new OrderInfo();

        int selectedId = breadGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        RadioButton breadRadioButton = findViewById(selectedId);

        info.setBreadEnum(breadRadioButton.getText().toString());

        int cheeseSelectedId = cheeseGroup.getCheckedRadioButtonId();
        RadioButton cheeseRadioButton = findViewById(cheeseSelectedId);

        info.setCheeseEnum(cheeseRadioButton.getText().toString());

        int sauceSelectedId = sauceGroup.getCheckedRadioButtonId();
        RadioButton sauceButton = findViewById(sauceSelectedId);
        info.setSauceEnum(sauceButton.getText().toString());

        List<String> toppings = new ArrayList<>();

        if (chickenBtn.isChecked())
            toppings.add(chickenBtn.getText().toString());

        if (beefBtn.isChecked())
            toppings.add(beefBtn.getText().toString());
        if (pepperoniBtn.isChecked())
            toppings.add(pepperoniBtn.getText().toString());
        if (mushroomBtn.isChecked())
            toppings.add(mushroomBtn.getText().toString());
        if (tomatoBtn.isChecked())
            toppings.add(tomatoBtn.getText().toString());
        if (onionBtn.isChecked())
            toppings.add(onionBtn.getText().toString());
        if (jalapenoBtn.isChecked())
            toppings.add(jalapenoBtn.getText().toString());
        if (capsicumBtn.isChecked())
            toppings.add(capsicumBtn.getText().toString());
        if (extraCheeseBtn.isChecked())
            toppings.add(extraCheeseBtn.getText().toString());
        if (!toppings.isEmpty()) {
            info.setToppings(toppings);
        }
        Calendar calender = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String date = dateFormat.format(calender.getTime());

        info.setOrderDate(date);
        return info;
    }


}

