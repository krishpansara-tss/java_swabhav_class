package com.bank.payment.methods;

import com.bank.account.BaseAccount;

import java.util.Scanner;

public class DigitalWalletPayment implements Payment{
    private String mobileNumber;
    @Override
    public void collectDetails() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter mobile number: ");
            mobileNumber = scanner.nextLine();

            if (mobileNumber.matches("[6-9]\\d{9}")) {
                System.out.println("Valid mobile number");
                break;
            } else {
                System.out.println("Invalid mobile number! Must be 10 digits and start with 6-9.");
            }
        }
    }

    @Override
    public void pay(BaseAccount account, double amount) {
        System.out.println("Payment Method : Digital Wallet ");
        System.out.println("Payment of : " + amount + " is processing");
        System.out.println("Mobile: " + mobileNumber);
        account.withdraw(amount);
        System.out.println("Payment done Successfully via Digital Wallet ");
    }
}
