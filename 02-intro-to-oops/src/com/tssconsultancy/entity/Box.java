package com.tssconsultancy.entity;

public class Box {
    double height;
    double width;
    double length;

    public Box(){

    }

    public Box( double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public void initializeBox(){
        height = 10;
        width = 10;
        length = 10;
    }

    public double calculateVoulme(){
        return height * width * length;
    }

    public void displayBox(){
        System.out.println("Width of the box is : " + width);
        System.out.println("Height of the box is : " + height);
        System.out.println("Length of the box is : " + length);
    }
}
