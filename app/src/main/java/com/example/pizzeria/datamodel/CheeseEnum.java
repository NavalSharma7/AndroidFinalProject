package com.example.pizzeria.datamodel;

public enum CheeseEnum {

    NO_CHEESE("No Cheese"),
    MOZZARELLA("Mozzarella"),
    CHEDDAR("Cheddar"),
    PARMESAN("Parmesan");

    CheeseEnum(String name) {
        this.displayName = name;
    }

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }
}
