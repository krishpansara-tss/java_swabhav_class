package com.tssconsultancy.multidimentional;

import java.util.Scanner;

public class MenuDriven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int operation = 0;
        int[][] matrix1 = null;
        int[][] matrix2 = null;

        do {
            System.out.println("\n\nChoose the number based on operation to perform");
            System.out.println("1. Read");
            System.out.println("2. Print");
            System.out.println("3. Addition");
            System.out.println("4. Multiplication");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            operation = scanner.nextInt();


            switch (operation) {
                case 1:
                    System.out.println("\nCreating matrix 1: ");
                    matrix1 = readMatrix(scanner);

                    System.out.println("\nCreating matrix 2: ");
                    matrix2 = readMatrix(scanner);

                    System.out.println("Matrix initiallized Successfully");

                    break;

                case 2:

                    if (matrix1 == null || matrix2 == null) {
                        System.out.println("Matrix not initialized!");
                    } else {
                        System.out.println("Matrix 1: ");
                        printMatrix(matrix1);

                        System.out.println("\nMatrix 2: ");
                        printMatrix(matrix2);
                    }
                    break;

                case 3:
                    if (matrix1 == null || matrix2 == null) {
                        System.out.println("Matrix not initialized!");
                    } else {

                        int[][] sumOfMatrix = additionOfMatrix(matrix1, matrix2);

                        if(sumOfMatrix != null){
                            System.out.println("The sum of the matrix is : ");
                            printMatrix(sumOfMatrix);
                        }else{
                            System.out.println("Invalid matrix to addition operation");
                        }
                    }

                    break;

                case 4:
                    if (matrix1 == null || matrix2 == null) {
                        System.out.println("Matrix not initialized!");

                    }else{

                        int[][] multipliedMatrix = multiplicationOfMatrix(matrix1, matrix2);
                        if(multipliedMatrix != null){
                            System.out.println("Multiplied Matrix : ");
                            printMatrix(multipliedMatrix);
                        }else{
                            System.out.println("Invalid matrix to addition operation");

                        }

                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;


                default:
                    System.out.println("Please enter the values between 1 to 5");
            }


        } while (true);
    }

    private static int[][] readMatrix(Scanner scanner){
        int n = 0, m = 0;

        do {
            System.out.print("Enter the no. of Rows : ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }
        } while (n <= 0);

        do {
            System.out.print("Enter the no. of Cols : ");
            if (scanner.hasNextInt()) {
                m = scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }
        } while (m <= 0);

        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                while (true) {
                    System.out.print("Enter value at [" + i + "][" + j + "]: ");

                    if (scanner.hasNextInt()) {
                        int val = scanner.nextInt();

                        if (val > 0) {
                            matrix[i][j] = val;
                            break;
                        } else {
                            System.out.println("Enter positive number only!");
                        }

                    } else {
                        System.out.println("Invalid input!");
                        scanner.next();
                    }
                }
            }
        }


        return matrix;
    }

    private static void printMatrix(int[][] matrix){

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print( matrix[i][j] +" ");
            }
            System.out.println();
        }

    }

    private static int[][] additionOfMatrix(int[][] matrix1, int[][] matrix2){
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("Matrix dimensions must be same for addition!");
            return null;
        }

        int[][] sumMatrix = new int[matrix1.length][matrix1[0].length];

        for(int i = 0; i < matrix1.length; i++){
            for(int j = 0; j < matrix1[0].length; j++){
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return sumMatrix;
    }

    private static int[][] multiplicationOfMatrix(int[][] matrix1, int[][] matrix2){
        if(matrix1[0].length != matrix2.length){
            System.out.println("Invalid Matrix for matrix multiplication!");
            return null;
        }

        int rows = matrix1.length;
        int cols = matrix2[0].length;
        int common = matrix1[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                for (int k = 0; k < common; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }

            }
        }

        return result;
    }


}
