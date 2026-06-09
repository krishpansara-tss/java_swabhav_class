package com.tssconsultancy.array;

import java.util.Scanner;

public class ProductArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = createArray(scanner);

        int n = array.length;
        int[] prod = new int[n];

        int allPriduct = 1;
        for(int i : array){
            allPriduct *= i;
        }

        for(int i = 0; i< n; i++){
            prod[i] = allPriduct/ array[i];
        }

        for(int i : prod){
            System.out.print(i+" ");
        }
    }

    public static int[] createArray(Scanner scanner){
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

        return inputArray;
    }
}
