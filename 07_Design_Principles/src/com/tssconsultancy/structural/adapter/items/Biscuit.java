package com.tssconsultancy.structural.adapter.items;

import com.tssconsultancy.structural.adapter.interfaces.IItems;

public class Biscuit implements IItems {
    private String name;
    private double price;

    public Biscuit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
