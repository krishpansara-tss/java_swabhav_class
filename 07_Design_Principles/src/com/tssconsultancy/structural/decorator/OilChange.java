package com.tssconsultancy.structural.decorator;

public class OilChange extends CarServiceDecorator {
    public OilChange(CarService carObj) {
        super(carObj);
    }

    @Override
    public double getCost() {
        return 500 + super.getCost();
    }
}
