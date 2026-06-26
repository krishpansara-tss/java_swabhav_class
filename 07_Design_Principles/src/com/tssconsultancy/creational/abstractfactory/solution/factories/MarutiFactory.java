package com.tssconsultancy.creational.abstractfactory.solution.factories;


import com.tssconsultancy.creational.abstractfactory.solution.interfaces.CarFactory;
import com.tssconsultancy.creational.factory.violation.model.Car;
import com.tssconsultancy.creational.factory.violation.model.Maruti;

public class MarutiFactory implements CarFactory {
    @Override
    public Car craeteCar() {
        return new Maruti();
    }
}
