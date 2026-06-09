package com.tssconsultancy.array;

import java.util.Scanner;

public class SumArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int n;
        do{
            n = scanner.nextInt();
        }while(n < 0);

        int[] array = new int[n];

        for(int i = 0; i < array.length; i++){
            System.out.print("\nEnter the "+ (i+1) +"th element of array : ");
            array[i] = scanner.nextInt();
        }


        printArray(array);

        int sum = sumOfArray(array);

        System.out.println("Sum of all of the element of array is : " + sum);
    }


    public static void printArray(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
    }

    public static int sumOfArray(int[] array){
        int sum = 0;
        for(int i : array){
            sum += i;
        }

        return sum;
    }
}
