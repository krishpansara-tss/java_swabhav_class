package com.bank.payment.methods;

import com.bank.account.BaseAccount;

import java.util.Scanner;

public class UpiPayment implements Payment {
    private String upiId;

    @Override
    public void collectDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your UPI id : ");
        while (true){
            upiId = scanner.nextLine();

            if(upiId.matches("^[a-zA-Z0-9._-]{2,}@[a-zA-Z]{2,}$")){
                break;
            }else{
                System.out.println("Invalid UPI ID! Example: name@bank");
            }
        }
    }

    @Override
    public void pay(BaseAccount account, double amount) {
        System.out.println("Payment Method : UPI ");
        System.out.println("UPI id : " + upiId);
        System.out.println("Payment of : " + amount + " is processing");
        account.withdraw(amount);
        System.out.println("Phone Pay par " + amount + " rupeee Khate me se gaye aur saamne waale ko prapt huee!!!");
        System.out.println("Dhanyawadddd");
        System.out.println("Phone Pay Karoo!!!!!");
        System.out.println("Payment done Successfully via UPI");
    }
}
