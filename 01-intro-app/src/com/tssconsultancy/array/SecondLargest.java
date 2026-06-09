package com.tssconsultancy.array;

import java.util.Scanner;

public class SecondLargest {
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

        int secondLargest = findSecondLargest(array);
        System.out.println("\nSecond Largest element of array : " + secondLargest);
    }

    public static int findSecondLargest(int[] array){
        int max = array[0];
        int secondLargest = array[0];

        for(int i : array){
            if(i > max){
                secondLargest = max;
                max = i;
            }
        }

        return secondLargest;
    }

    public static void printArray(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
    }
}
