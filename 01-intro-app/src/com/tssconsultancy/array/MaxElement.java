package com.tssconsultancy.array;

import java.util.Scanner;

public class MaxElement {
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

        int max = findMaximun(array);
        System.out.println("\nMaximum element of array : " + max);
    }

    public static int findMaximun(int[] array){
        int max = array[0];

        for(int i : array){
            if(i > max){
                max = i;
            }
        }

        return max;
    }

    public static void printArray(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
    }
}
