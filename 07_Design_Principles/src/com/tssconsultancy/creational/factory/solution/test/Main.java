package com.tssconsultancy.creational.factory.solution.test;

import com.tssconsultancy.creational.factory.solution.enums.CarType;
import com.tssconsultancy.creational.factory.solution.factorymethods.CarFactory;
import com.tssconsultancy.creational.factory.solution.model.Car;

public class Main {
    public static void main(String[] args) {
        Car c1 = CarFactory.createCar(CarType.MARUTI);
        Car c2 = CarFactory.createCar(CarType.HYUNDAI);
        Car c3 = CarFactory.createCar(CarType.TATA);

        System.out.println(c1.getClass().getName());
        System.out.println(c2.getClass().getName());
        System.out.println(c3.getClass().getName());

    }
}
