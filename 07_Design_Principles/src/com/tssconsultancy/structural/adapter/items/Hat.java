package com.tssconsultancy.structural.adapter.items;

public class Hat {
    private String shortName;
    private String longName;
    private int basePrice;
    private int tax;

    public Hat(String shortName, String longName, int basePrice, int tax) {
        this.shortName = shortName;
        this.longName = longName;
        this.basePrice = basePrice;
        this.tax = tax;
    }

    public String getShortName() {
        return shortName;
    }

    public int getPrice() {
        return basePrice + tax;
    }
}
