package com.bank.payment.methods;

import com.bank.account.BaseAccount;

import java.util.Scanner;

public class NetBankingPayment implements  Payment{
    String username;


    @Override
    public void collectDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Username: ");
        username = scanner.nextLine();
    }

    @Override
    public void pay(BaseAccount account, double amount) {
        System.out.println("Payment Method : Net Banking ");
        System.out.println("Payment of : " + amount + " is processing");
        account.withdraw(amount);
        System.out.println("Payment done Successfully via Net Banking");
    }
}
