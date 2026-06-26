package com.tssconsultancy.creational.abstractfactory.solution.model;

public class Car {
    private String carName;
    private double price;

    public Car(String carName, double price) {
        this.carName = carName;
        this.price = price;
    }

    public Car() {
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
