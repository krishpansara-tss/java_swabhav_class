package com.tssconsultancy.array;

import java.util.Scanner;

public class ArrayFirst {
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

        for(int i : array){
            System.out.print(i + " ");
        }
    }

    public static void printArray(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
    }
}
