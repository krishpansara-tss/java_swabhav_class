package com.shape.test;

import com.shape.entity.Circle;
import com.shape.entity.Ractangle;
import com.shape.entity.Shape;

public class ShapeTest {
    public static void main(String[] args) {
        Shape circle = new Circle(10);
        Shape ractangle = new Ractangle(5, 10);

        circle.calculateArea();
        ractangle.calculateArea();
    }
}
