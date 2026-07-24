package com.tsscosultancy.model;

public class Calculator {

    public int addition(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public double division(int a, int b) throws ArithmeticException {
        return a / b;
    }
}
