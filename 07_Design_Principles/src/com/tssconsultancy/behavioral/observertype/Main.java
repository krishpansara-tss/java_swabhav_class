package com.tssconsultancy.behavioral.observertype;

import com.tssconsultancy.behavioral.observertype.factory.NotifierFactory;
import com.tssconsultancy.behavioral.observertype.service.AccountService;
import com.tssconsultancy.behavioral.observertype.subject.Account;

import java.util.Scanner;
import java.util.Set;
import com.tssconsultancy.behavioral.observertype.interfaces.INotifier;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final AccountService accountService = new AccountService();

    public static void main(String[] args) {

        while (true) {
            printMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // FIX buffer issue

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    private static void createAccount() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Choose Notifications: 1.SMS 2.Whatsapp 3.Email");
        String input = scanner.nextLine();

        Set<INotifier> notifiers = NotifierFactory.createNotifiers(input);

        Account acc = new Account(name, balance, notifiers);
        accountService.addAccount(acc);

        System.out.println("Account Created! ID: " + acc.getAccountId());
    }

    private static void deposit() {
        System.out.print("Enter Account ID: ");
        String id = scanner.nextLine();

        Account acc = accountService.findAccount(id);

        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        acc.deposit(amount);
    }

    private static void withdraw() {
        System.out.print("Enter Account ID: ");
        String id = scanner.nextLine();

        Account acc = accountService.findAccount(id);

        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        acc.withdraw(amount);
    }
}