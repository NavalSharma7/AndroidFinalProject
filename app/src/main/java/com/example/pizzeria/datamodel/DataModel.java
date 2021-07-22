package com.example.pizzeria.datamodel;

import java.util.ArrayList;
import java.util.List;

public class DataModel {

    public static List<OrderInfo> getOrderList(){

        List<OrderInfo> orders = new ArrayList<>();
        OrderInfo info = new OrderInfo();
        info.setAmount(20);
        info.setOrderDate("21/06/2021");
        info.setOrderId(1);
        info.setCheeseEnum(CheeseEnum.CHEDDAR);
        orders.add(info);
        return orders;
    }
}
