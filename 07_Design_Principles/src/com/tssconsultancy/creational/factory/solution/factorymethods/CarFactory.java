package com.tssconsultancy.creational.factory.solution.factorymethods;

import com.tssconsultancy.creational.factory.solution.enums.CarType;
import com.tssconsultancy.creational.factory.solution.model.Car;
import com.tssconsultancy.creational.factory.solution.model.Maruti;
import com.tssconsultancy.creational.factory.solution.model.Hyundai;
import com.tssconsultancy.creational.factory.solution.model.Tata;


public class CarFactory {
    public static Car createCar(CarType type){
        switch (type){
            case MARUTI:
                return new Maruti();

            case TATA:
                return new Tata();

            case HYUNDAI:
                return new Hyundai();

            default:
                System.out.println("please enter valid brand name");
                return new Car();

        }
    }
}
