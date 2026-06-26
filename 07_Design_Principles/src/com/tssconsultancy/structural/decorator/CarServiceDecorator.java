package com.tssconsultancy.structural.decorator;

abstract class CarServiceDecorator implements CarService {

    protected CarService carObj;

    public CarServiceDecorator(CarService carObj) {
        this.carObj = carObj;
    }

    @Override
    public double getCost() {
        return carObj.getCost();
    }
}