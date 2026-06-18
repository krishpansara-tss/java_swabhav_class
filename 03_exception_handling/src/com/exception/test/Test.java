package com.exception.test;

public class Test {
    public static void main(String[] args) {
        int num1  = 1;
        int num2 = 1;

        try{
            num1 = Integer.parseInt(args[0]);
            num2 = Integer.parseInt(args[1]);

            double division  = num1 / num2;
            System.out.println("Devision : " + division);
        } catch (ArithmeticException e) {
            System.out.println("Error : " + e);

            System.out.println("Don't enter 0 as num2");
        }

        System.out.println("Exiting");
    }
}
