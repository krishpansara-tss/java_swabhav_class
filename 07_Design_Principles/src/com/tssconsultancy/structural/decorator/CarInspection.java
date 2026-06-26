package com.tssconsultancy.structural.decorator;

public class CarInspection implements CarService {
    @Override
    public double getCost() {
        return 1000;
    }
}
