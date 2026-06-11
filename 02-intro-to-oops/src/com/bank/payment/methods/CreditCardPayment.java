package com.bank.payment.methods;

import com.bank.account.BaseAccount;

import java.util.Scanner;

public class CreditCardPayment implements Payment{
    private String creditCardNumber;
    @Override
    public void collectDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your credit Card Number : ");
        while (true) {
            if (scanner.hasNextLine()) {
                creditCardNumber = scanner.nextLine();

                if(creditCardNumber.matches("\\d{16}")){
                    break;
                }else if(creditCardNumber.isEmpty()){
                    System.out.println("Empty value is not valid");
                } else {
                    System.out.println("Please enter valid credit crad number, enter 16 digits");
                }
            } else {
                System.out.println("Please enter digits only");
            }
        }

        System.out.println("Your credit card number : " + creditCardNumber);
    }

    @Override
    public void pay(BaseAccount account, double amount) {
        System.out.println("Payment Method : Credit Card ");
        System.out.println("Payment of : " + amount + " is processing");
        account.withdraw(amount);
        System.out.println("Using Credit Card : **** **** **** " + (creditCardNumber.substring(creditCardNumber.length() - 4)));
        System.out.println("Payment done Successfully via Credit Card");
    }
}
