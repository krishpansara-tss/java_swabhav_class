package com.lspsolution;

public class Test {
    public static void makeBirdFly(FlyingBird bird) {
        bird.fly();
    }
    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        Bird penguin = new Penguin();

        makeBirdFly(sparrow);
    }
}
