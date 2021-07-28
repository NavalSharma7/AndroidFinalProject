package com.example.pizzeria.datamodel;

import java.util.ArrayList;
import java.util.List;

public class DataModel {

    public static ArrayList<OrderInfo> getOrderList(){

        ArrayList<OrderInfo> orders = new ArrayList<>();
        OrderInfo info = new OrderInfo();
        info.setAmount(20);
        info.setOrderDate("21/06/2021");
        info.setOrderId(1);
        info.setCheeseEnum(CheeseEnum.CHEDDAR);
        orders.add(info);
        return orders;
    }
}
