package com.bank;

import com.bank.service.AccountService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountService accountService = new AccountService();
        String opr;

        while(true){
            System.out.println("Choose Operation");
            System.out.println("1. Create an Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Display Account detail");
            System.out.println("6. Exit");
            System.out.println("Enter your choice : ");

            opr = scanner.nextLine();

            switch (opr){
                case "1":
                    System.out.println("Enter name : ");
                    String name = scanner.nextLine();
                    System.out.println("Enter balance : ");
                    double balance = scanner.nextDouble();
                    accountService.createAccount(name, balance);
                    break;
                case "2":
                    System.out.println("Enter account number : ");
                    String accountNumber = scanner.nextLine();
                    System.out.println("Enter amount : ");
                    balance = scanner.nextDouble();
                    accountService.withdraw(accountNumber, balance);
                    break;
                case "3":
                    System.out.println("Enter account number : ");

                    accountNumber = scanner.nextLine();
                    System.out.println("Enter amount : ");

                    balance = scanner.nextDouble();
                    accountService.deposit(accountNumber, balance);
                    break;
                case "4":
                    System.out.println("Enter sender's account number : ");
                    String senderAccountNumber = scanner.nextLine();
                    System.out.println("Enter receiver's account number : ");
                    String receiverAccountNumber = scanner.nextLine();
                    System.out.println("Enter amount : ");

                    balance = scanner.nextDouble();
                    accountService.transfer(senderAccountNumber, receiverAccountNumber, balance);
                    break;
                case "5":
                    System.out.println("Enter account number : ");
                    accountNumber = scanner.nextLine();
                    accountService.displayAccountDetail(accountNumber);
                    break;
                case "6":
                    System.out.println("Program Exiting....");
                    return;
                default:
                    System.out.println("Enter valid operation");

            }
        }

    }
}
