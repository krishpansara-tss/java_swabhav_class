package com.tssconsultancy.creational.abstractfactory.solution.factories;

import com.tssconsultancy.creational.abstractfactory.solution.interfaces.CarFactory;
import com.tssconsultancy.creational.factory.violation.model.Car;
import com.tssconsultancy.creational.factory.violation.model.Tata;

public class TataFactory implements CarFactory {
    @Override
    public Car craeteCar() {
        return new Tata();
    }
}
