package com.tssconsultancy.test;

import java.util.Scanner;

public class WaterBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter unit Consumed : ");
        int unitConsumed = scanner.nextInt();
        int meterCharge = 75;

        int total_water_bill = calculateBill(unitConsumed, meterCharge);

        System.out.println("Total bill is : " + total_water_bill);

    }

    public static int calculateBill(int unitConsumed, int meterCharge){

        int charge = calculateCharge(unitConsumed);

        return charge + meterCharge;
    }

    public static int calculateCharge(int unitConsumed){
        int charge;
        if(unitConsumed <= 100){
            charge = unitConsumed * 5;
        }else{
            if(unitConsumed <= 250){
                charge = unitConsumed * 10;
            }else{
                charge = unitConsumed * 20;
            }
        }

        return charge;
    }
}
