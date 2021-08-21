package com.example.pizzeria.datamodel;

import java.util.ArrayList;
import java.util.List;

public class DataModel {

    // a class fpr dummy data for testing

    public static ArrayList<OrderInfo> getOrderList() {

        ArrayList<OrderInfo> orders = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            OrderInfo info = new OrderInfo();

            info.setOrderDate("21/06/2021");
            info.setBreadEnum(BreadEnum.THICK_CRUST.getDisplayName());
            info.setCheeseEnum(CheeseEnum.CHEDDAR.getDisplayName());
            info.setSauceEnum(BaseSauceEnum.BBQ.getDisplayName());
            List<String> toppings = new ArrayList<>();
            toppings.add("peperoni");
            toppings.add("extra cheese");
            toppings.add("tomato");
            toppings.add("chicken");

            info.setToppings(toppings);
            orders.add(info);
        }

        return orders;
    }
}
