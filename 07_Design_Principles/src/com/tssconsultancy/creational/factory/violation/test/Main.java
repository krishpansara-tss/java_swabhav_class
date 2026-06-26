package com.tssconsultancy.creational.factory.violation.test;

import com.tssconsultancy.creational.factory.violation.model.Car;

public class Main {
    public static void main(String[] args) {
        Car c1 = new Car("Gadi1", 10);
        Car c2 = new Car("Gadi2", 100);
        Car c3 = new Car("Gadi3", 1000);
        Car c4 = new Car("Gadi4", 10000);
    }
}
