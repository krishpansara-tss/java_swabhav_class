package com.tssconsultancy.structural.decorator.hatwalaexample.decorator;

import com.tssconsultancy.structural.decorator.hatwalaexample.interfaces.Hat;

public abstract class RibbonDecorator implements Hat {
    protected Hat hatObj;

    public RibbonDecorator(Hat hatObj) {
        this.hatObj = hatObj;
    }

    @Override
    public double getPrice() {
        return hatObj.getPrice();
    }
}
