package com.tssconsultancy.array;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.sort;

public class SquareArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.print("Enter the size of the array : ");
        while(true){
            if(scanner.hasNextInt()){
                n = scanner.nextInt();
                break;
            }else{
                System.out.println("Please enter the valid input (integer)");
                scanner.next();
            }
        }

        int[] inputArray = new int[n];

        for(int i = 0; i < n; i++){
            while (true) {
                System.out.print("Enter value at [" + i + "] : ");

                if (scanner.hasNextInt()) {
                    int val = scanner.nextInt();
                    if(i == 0){
                        inputArray[i] = val;
                        break;
                    }else{
                        if(val > inputArray[i- 1]) {
                            inputArray[i] = val;
                            break;
                        }else{
                            System.out.println("Enter larger number from previous");
                        }
                    }

                } else {
                    System.out.println("Invalid input!");
                    scanner.next();
                }
            }
        }

        int[] squaredArray = new int[n];

        for(int i = 0; i < n; i++){
            squaredArray[i] = inputArray[i] * inputArray[i];
        }

        Arrays.sort(squaredArray);

        for(int i : squaredArray){
            System.out.print(i+ " ");
        }
    }
}
