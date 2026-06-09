package com.tssconsultancy.array;

import java.util.Scanner;

public class ArraySearch {
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

        System.out.print("Array : ");
        printArray(array);

        System.out.print("Enter value of the element to find : ");
        int key = scanner.nextInt();


        findElement(array, key);




    }

    public static void printArray(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
    }

    public static void findElement(int[] array, int key){
        boolean found = false;
        for(int i = 0; i < array.length; i++){
            if(array[i] == key){
                found = true;
                System.out.println("Value found on index : " + i);
                break;
            }
        }

        if(!found){
            System.out.println("Value not found in array");
        }
    }


}
