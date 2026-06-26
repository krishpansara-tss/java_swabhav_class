package com.tssconsultancy.structural.decorator.hatwalaexample.decorator;

import com.tssconsultancy.structural.decorator.CarService;
import com.tssconsultancy.structural.decorator.hatwalaexample.interfaces.Hat;

public class SilverRibbon extends RibbonDecorator {

    public SilverRibbon(Hat hatObj) {
        super(hatObj);
    }

    @Override
    public double getPrice() {
        return 30 + super.getPrice();
    }
}
