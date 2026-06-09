package com.tssconsultancy.test;

import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        int[] currency = {2000, 500, 200, 100};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdrawn (in multiplier of 100): ");
        int amount = scanner.nextInt();

        while(amount % 100 != 0 || amount < 100){
            System.out.print("Enter amount to withdrawn (in multiplier of 100): ");

            amount = scanner.nextInt();
        }

        noteCalcultor(amount, currency);

    }

    public static void noteCalcultor(int amount, int[] currency){
        for (int j : currency) {
            int notesCount = 0;
            if (amount == 0) {
                break;
            }

            while (amount >= j) {
                amount = amount - j;
                notesCount++;
            }
            if (notesCount != 0) {
                System.out.println("No. of " + j + " Note : " + notesCount);
            }
        }
    }
}
