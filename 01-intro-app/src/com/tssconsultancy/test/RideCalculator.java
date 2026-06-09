package com.tssconsultancy.test;

import java.util.Scanner;

public class RideCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Height (in cm): ");
        int height = scanner.nextInt();

        int bill = 0;

        if(height > 120){
            System.out.println("Can Ride\n\n");

            System.out.print("Enter Age : ");
            int age = scanner.nextInt();

            if(age < 12){
                bill += 5;
            } else if (age > 12 && age < 18) {
                bill += 7;
            } else {
                if(age > 45 && age < 55){
                    bill += 0;
                }else{
                    bill += 12;
                }
            }

            System.out.println("bill befire photot: " + bill);
            int wantPhotos;

            do {
                System.out.print("For photos enter 1 else 0 : ");
                wantPhotos = scanner.nextInt();
            }while(wantPhotos != 0 && wantPhotos != 1);

            if(wantPhotos == 1){
                bill += 3;
            }


        }else{
            System.out.println("Can't Ride");
        }


        System.out.println("Total Bill = " + bill);
    }


}
