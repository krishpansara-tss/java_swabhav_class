package com.tssconsultancy.structural.decorator;

public class WheelAlign extends CarServiceDecorator {

    public WheelAlign(CarService carObj) {
        super(carObj);
    }

    @Override
    public double getCost() {
        return 400 + super.getCost();
    }
}
