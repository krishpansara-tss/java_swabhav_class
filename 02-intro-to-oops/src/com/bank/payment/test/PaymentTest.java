package com.bank.payment.test;

import com.bank.account.Account;
import com.bank.payment.methods.*;
import com.bank.payment.service.PaymentService;

import java.util.Scanner;

public class PaymentTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentService paymentService = new PaymentService();
        while (true) {
            System.out.println("\n===== Payment Menu =====");
            System.out.println("1. Credit Card");
            System.out.println("2. Debit Card");
            System.out.println("3. UPI");
            System.out.println("4. Net Banking");
            System.out.println("5. Digital Wallet");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = validateChoiceInput(scanner);

            if (choice == 6) break;

            System.out.print("Enter amount: ");
            double amount = validateAmountInput(scanner);

            Payment payment = null;

            switch (choice) {
                case 1:
                    payment = new CreditCardPayment();
                    break;
                case 2:
                    payment = new DebitCardPayment();
                    break;

                case 3:
                    payment = new UpiPayment();
                    break;
                case 4:
                    payment = new NetBankingPayment();
                    break;
                case 5:
                    payment = new DigitalWalletPayment();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }



//            paymentService.paymentProcess(payment, amount);
        }
    }

    public static int validateChoiceInput(Scanner scanner){
        int value;

        while(true){
            if(scanner.hasNextInt()){
                value = scanner.nextInt();
                break;
            }else{
                System.out.println("Enter number only. Enter Again");
                scanner.next();
            }
        }

        return value;
    }

    public static double validateAmountInput(Scanner scanner){
        double value;

        while(true){
            if(scanner.hasNextDouble()){
                value = scanner.nextDouble();
                if(value < 0){
                    System.out.println("Amount can't be negative, Enter Again");
                }else{
                    break;
                }
            }else{
                System.out.println("Enter number only. Enter Again");
                scanner.next();
            }
        }

        return value;
    }
}
