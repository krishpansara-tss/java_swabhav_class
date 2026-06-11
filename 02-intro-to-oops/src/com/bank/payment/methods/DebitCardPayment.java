package com.bank.payment.methods;

import com.bank.account.BaseAccount;

import java.util.Scanner;

public class DebitCardPayment implements Payment {
    private String debitCardNumber;
    @Override
    public void collectDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your debit Card Number : ");

        while (true) {
            if (scanner.hasNextLine()) {
                debitCardNumber = scanner.nextLine();

                if(debitCardNumber.matches("\\d{16}")){
                    break;
                }else if(debitCardNumber.isEmpty()){
                    System.out.println("Empty value is not valid");
                } else {
                    System.out.println("Please enter valid credit crad number, enter 16 digits");
                }
            } else {
                System.out.println("Please enter digits only");
            }
        }


        System.out.println("Your credit card number : " + debitCardNumber);
    }

    @Override
    public void pay(BaseAccount account, double amount) {
        System.out.println("Payment Method : Debit Card ");
        System.out.println("Using Debit Card : **** **** **** " + (debitCardNumber.substring(debitCardNumber.length() - 4)));
        System.out.println("Payment of : " + amount + " is processing");
        account.withdraw(amount);

        System.out.println("Payment done Successfully via Debit Card");

    }
}
