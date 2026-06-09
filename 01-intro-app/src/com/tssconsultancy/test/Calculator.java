package com.tssconsultancy.test;

import java.util.Scanner;

public class Calculator {
    public static  void main(String[] args){
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the input for following operation:\n" +
                "1. Addition\n" +
                "2. Subtraction\n" +
                "3. Multiplication\n" +
                "4. Division\n" +
                "0. Exit");

        int opr = sc.nextInt();

        while(opr != 0){
            System.out.print("Enter num 1 : ");
            int num1 = sc.nextInt();

            System.out.print("Enter num 2 : ");
            int num2 = sc.nextInt();

            if(opr == 1){
                int sum = addition(num1, num2);
                System.out.println("Sum of " + num1 + " & " + num2 + " is = " + sum);

            }else if(opr == 2){
                int sub = subtraction(num1, num2);
                System.out.println("Sum of " + num1 + " & " + num2 + " is = " + sub);

            }else if(opr == 3){
                int multi = multiplication(num1, num2);
                System.out.println("Sum of " + num1 + " & " + num2 + " is = " + multi);

            }else if(opr == 4){
                int div = division(num1, num2);
                System.out.println("Sum of " + num1 + " & " + num2 + " is = " + div);

            }else{
                break;
            }

            System.out.println("Enter the input for following operation:\n" +
                    "1. Addition\n" +
                    "2. Subtraction\n" +
                    "3. Multiplication\n" +
                    "4. Division\n" +
                    "0. Exit");

            opr = sc.nextInt();
        }
    }

    public static  int addition(int num1, int num2){
        return num1 + num2;
    }

    public static  int subtraction(int num1, int num2){
        return num1 - num2;
    }

    public static  int multiplication(int num1, int num2){
        return num1 * num2;
    }

    public static  int division(int num1, int num2){
        return num1 / num2;
    }

}
