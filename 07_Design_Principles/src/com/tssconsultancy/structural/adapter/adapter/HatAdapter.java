package com.tssconsultancy.structural.adapter.adapter;

import com.tssconsultancy.structural.adapter.interfaces.IItems;
import com.tssconsultancy.structural.adapter.items.Hat;

public class HatAdapter implements IItems {
    private Hat hat;

    public HatAdapter(Hat hat) {
        this.hat = hat;
    }

    @Override
    public String getName() {
        return hat.getShortName();
    }

    @Override
    public double getPrice() {
        return hat.getPrice();
    }
}
