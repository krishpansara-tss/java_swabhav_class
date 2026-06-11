package com.shape.entity;

public class Ractangle extends Shape{
    int length, width;

    public Ractangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void calculateArea() {
        System.out.println("Area of ractangle is : " + ( length * width ));
    }
}
