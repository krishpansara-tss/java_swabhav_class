package com.tssconsultancy.structural.decorator.hatwalaexample.decorator;

import com.tssconsultancy.structural.decorator.hatwalaexample.interfaces.Hat;

public class GoldenRibbon extends RibbonDecorator{
    public GoldenRibbon(Hat hatObj) {
        super(hatObj);
    }

    @Override
    public double getPrice() {
        return 50 + super.getPrice();
    }
}
