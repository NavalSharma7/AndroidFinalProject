package com.example.pizzeria.datamodel;

public enum BreadEnum {
    REGULAR("Regular Crust"),
    THIN_CRUST("Thin Crust"),
    THICK_CRUST("Thick Crust");

    BreadEnum(String name) {
        this.displayName = name;
    }

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }
}
