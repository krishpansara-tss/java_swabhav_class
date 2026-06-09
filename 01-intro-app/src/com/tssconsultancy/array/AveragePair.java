package com.tssconsultancy.array;

import java.util.Arrays;
import java.util.Scanner;

public class AveragePair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] inputArray = createArray(scanner);

        Arrays.sort(inputArray);

        double average = calculateAverage(inputArray);

        boolean found = false;

        for(int i = 0; i < inputArray.length; i++){
            double valToFind = Math.abs(inputArray[i] - average);

            if(findElement(inputArray, valToFind)){
                System.out.println("Pair exist: " + inputArray[i] + " & " + valToFind);
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("No pair exist");
        }

    }

    public static boolean findElement(double[] array, double key){
        boolean found = false;
        for(int i = 0; i < array.length; i++){
            if(array[i] == key){
                found = true;
                System.out.println("Value found on index : " + i);
                break;
            }
        }
        return found;
    }

    public static double calculateAverage(double[] array){
        double avg = 0;

        for(double i : array){
            avg += i;
        }

        return avg / array.length ;
    }

    public static double[] createArray(Scanner scanner){
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

        double[] inputArray = new double[n];

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
