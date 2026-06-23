package com.lspviolation;

public class Test {
    public static void makeBirdFly(Bird bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird penguin = new Penguin();
        sparrow.fly();
        penguin.fly();

        makeBirdFly(sparrow);
        makeBirdFly(penguin);
    }
}
