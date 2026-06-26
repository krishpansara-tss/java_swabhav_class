package com.tssconsultancy.structural.decorator;

public class Main {
    public static void main(String[] args) {
        CarService service = new CarInspection();

        service = new OilChange(service);
        service = new WheelAlign(service);

        System.out.println("Total Cost: " + service.getCost());
    }
}
