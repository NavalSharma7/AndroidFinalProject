package com.example.pizzeria.datamodel;

import android.os.Parcel;
import android.os.Parcelable;


import java.util.ArrayList;
import java.util.List;


public class OrderInfo implements Parcelable {


    private String breadEnum;


    private String cheeseEnum;


    private String sauceEnum;


    private List<String> toppings;


    private String orderDate;


    private int orderId;


    public String getBreadEnum() {
        return breadEnum;
    }

    public void setBreadEnum(String breadEnum) {
        this.breadEnum = breadEnum;
    }

    public String getCheeseEnum() {
        return cheeseEnum;
    }

    public String getSauceEnum() {
        return sauceEnum;
    }

    public void setSauceEnum(String sauceEnum) {
        this.sauceEnum = sauceEnum;
    }

    public void setCheeseEnum(String cheeseEnum) {
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


    public OrderInfo() {
    }

    public OrderInfo(Parcel parcel) {
        this.orderId = parcel.readInt();
        this.orderDate = parcel.readString();
        this.toppings = new ArrayList<String>();
        parcel.readList(toppings, OrderInfo.class.getClassLoader());
        this.breadEnum = parcel.readString();
        this.sauceEnum = parcel.readString();
        this.cheeseEnum = parcel.readString();

    }

    public static final Creator<OrderInfo> CREATOR = new Creator<OrderInfo>() {
        @Override
        public OrderInfo createFromParcel(Parcel in) {
            return new OrderInfo(in);
        }

        @Override
        public OrderInfo[] newArray(int size) {
            return new OrderInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(orderId);
        dest.writeString(orderDate);
        dest.writeList(toppings);
        dest.writeString(this.breadEnum);
        dest.writeString(this.sauceEnum);
        dest.writeString(this.cheeseEnum);

    }
}
