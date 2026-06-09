package com.bank.test;

import com.bank.entity.Account;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Account[] accountArray = new Account[10];
        Scanner scanner = new Scanner(System.in);
        int accountCount = 0;

        int operation;
        while(true){
            System.out.println("Enter the operation you want to perform");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Get Account Details");

            while(true){
                if(scanner.hasNextInt()){
                    operation = scanner.nextInt();
                    break;
                }else{
                    System.out.println("Please enter valid number");
                    scanner.next();
                }
                System.out.println("Please select the operation : ");
            }

            switch (operation){
                // craete account
                case 1:
                    Account newAccount = createAccount(scanner);
                    // add new account in the array
                    accountArray[accountCount++] = newAccount;
                    System.out.println("Account created successfully");
                    break;

                // deposit
                case 2:

                    Account currAccountToDeposit = accountVerification(accountArray, scanner);
                    if(currAccountToDeposit != null){
                        int amountToDeposit = inputAmount(scanner);
                        if(currAccountToDeposit.deposit(amountToDeposit)){
                            System.out.println("Operation Done successfully");
                        }else{
                            System.out.println("Operation failed");
                        }
                    }else{
                        System.out.println("No account found");
                    }
                    break;

                // withdraw
                case 3:
                    Account currAccountToWithdraw = accountVerification(accountArray, scanner);
                    if(currAccountToWithdraw != null){
                        int amountToWithdraw = inputAmount(scanner);
                        if(currAccountToWithdraw.deposit(amountToWithdraw)){
                            System.out.println("Operation Done successfully");
                        }else{
                            System.out.println("Operation Done successfully");
                        }
                    }else{
                        System.out.println("No account found");
                    }
                    break;

                // transfer
                case 4:
                    System.out.println("Enter Details about the sender's account : ");
                    Account accountSender = accountVerification(accountArray, scanner);
                    if(accountSender == null){
                        System.out.println("No account exist");
                        break;
                    }
                    System.out.println("Enter Details about the receiver's account : ");
                    Account accountReceiver = accountVerification(accountArray, scanner);

                    if(accountReceiver == null){
                        System.out.println("No account exist");
                        break;
                    }

                    int amountToTransfer = inputAmount(scanner);

                    boolean sender = accountSender.withdraw(amountToTransfer);
                    boolean reciever = accountReceiver.deposit(amountToTransfer);

                    if(sender && reciever){
                        System.out.println("Transferred Successfully");
                    }else if(sender && !reciever){
                        System.out.println("Some error occured!");
                    }
                    break;

                // account detail
                case 5:
                    Account currAccountToDisplay = accountVerification(accountArray, scanner);
                    if(currAccountToDisplay != null){
                        currAccountToDisplay.displayAccountDetails();
                    }else{
                        System.out.println("Account not found");
                    }

                    break;

                default:
                    System.out.println("Program Exited");
                    break;
            }
        }
    }

    public static int inputAmount(Scanner scanner){
        int amount;

        while(true){
            System.out.println("\nEnter amount : ");

            if(scanner.hasNextInt()){
                amount = scanner.nextInt();

                if (amount >= 0) {
                    break;
                } else {
                    System.out.println("Amount cannot be negative");
                }
            }else{
                System.out.println("Invalid input. Please enter a number");
                scanner.next();
            }
        }
        return amount;
    }

    public static Account accountVerification(Account[] accountArray, Scanner scanner){
        int accountNumber;
        while(true){
            if(scanner.hasNextInt()){
                accountNumber = scanner.nextInt();
                for(Account a : accountArray)
                    if (a.getAccountNumber() == accountNumber) {
                           return a;
                    }
                break;
            }else{
                System.out.println("Please enter only digits.");
                scanner.next();
            }
        }
        System.out.println("Account not found");
        return null;
    }

    public static Account createAccount(Scanner scanner){
        String name;
        int accountType, balance;

        System.out.print("\nEnter your Name : ");
        name = scanner.next();

        System.out.print("\nEnter type of the account you wanna to open\n1. Saving\n2. Current\n Enter your choice : ");
        while(true){
            if(scanner.hasNextInt()){
                accountType = scanner.nextInt();
                if (accountType == 1 || accountType == 2) {
                    break;
                } else {
                    System.out.println("Please enter 1 or 2.");
                }
            }else{
                System.out.println("Please enter 1 or 2.");
                scanner.next();
            }
        }
        System.out.println("\nEnter balance of your account : ");

        while(true){
            if(scanner.hasNextInt()){
                balance = scanner.nextInt();
                if (balance >= 0) {
                    break;
                } else {
                    System.out.println("Balance cannot be negative");
                }
            }else{
                System.out.println("Invalid input. Please enter a number");
                scanner.next();
            }
        }

        return new Account(name, balance, accountType);
    }
}
