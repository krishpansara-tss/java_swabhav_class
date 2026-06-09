package com.tssconsultancy.test;

import com.tssconsultancy.entity.Box;

public class BoxTest {
    public static void main(String[] args) {
        Box b1 = new Box();
        Box b2 = new Box(10,20,30);

        System.out.println("BOX 1");
        System.out.println("Volume of the box before intialization is: "+b1.calculateVoulme());
        b1.initializeBox();
        b1.displayBox();
        System.out.println("Volume of the box after intialization is: "+b1.calculateVoulme());

        System.out.println("BOX 2");
        b1.displayBox();
        System.out.println("Volume of the box is: "+b2.calculateVoulme());
    }
}
