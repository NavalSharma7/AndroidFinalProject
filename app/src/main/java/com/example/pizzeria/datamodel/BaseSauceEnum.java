package com.example.pizzeria.datamodel;

public enum BaseSauceEnum {


    BBQ("BBQ"),
    CREAMY_GARLIC("Creamy Garlic"),
    PESTO("Pesto"),
    ITALIAN_TOMATO("Italian Tomato");

     BaseSauceEnum(String name) {
        this.displayName = name;
    }

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }
}
