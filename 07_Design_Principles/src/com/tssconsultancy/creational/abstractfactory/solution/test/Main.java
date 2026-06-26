package com.tssconsultancy.creational.abstractfactory.solution.test;

import com.tssconsultancy.creational.abstractfactory.solution.factories.HyundaiFactory;
import com.tssconsultancy.creational.abstractfactory.solution.factories.MarutiFactory;
import com.tssconsultancy.creational.abstractfactory.solution.interfaces.CarFactory;
import com.tssconsultancy.creational.abstractfactory.solution.model.Maruti;
import com.tssconsultancy.creational.factory.violation.model.Car;

public class Main {
    public static void main(String[] args) {;
        CarFactory marutiFactory = new MarutiFactory();

        Car c1 = marutiFactory.craeteCar();

    }
}
