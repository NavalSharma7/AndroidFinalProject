package com.example.pizzeria.datamodel;

import java.util.List;

public class OrderInfo {

    private BreadEnum breadEnum;
    private CheeseEnum cheeseEnum;
    private List<String> toppings;
    private String orderDate;
    private int orderId;
    private double amount;


    public BreadEnum getBreadEnum() {
        return breadEnum;
    }

    public void setBreadEnum(BreadEnum breadEnum) {
        this.breadEnum = breadEnum;
    }

    public CheeseEnum getCheeseEnum() {
        return cheeseEnum;
    }

    public void setCheeseEnum(CheeseEnum cheeseEnum) {
        this.cheeseEnum = cheeseEnum;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }






}
