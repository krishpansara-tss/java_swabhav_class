package com.shape.entity;

public class Circle extends Shape {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        System.out.println("Area of the circle : " + (3.14*radius*radius));
    }
}
