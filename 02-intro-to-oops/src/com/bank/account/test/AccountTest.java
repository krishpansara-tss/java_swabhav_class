package com.bank.account.test;

import com.bank.account.BaseAccount;
import com.bank.account.CurrentBaseAccount;
import com.bank.account.SavingBaseAccount;
import com.bank.payment.interaction.PaymentMenu;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        BaseAccount[] baseAccounts = new BaseAccount[10];
//        ArrayList<Account> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int accountCount = 0;

        int operation;
        while(true){
            System.out.println("\n\nEnter the operation you want to perform");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Get Account Details");
            System.out.println("6. Pay");
            System.out.println("7. Exit");

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
                    if(accountCount == 10){
                        System.out.println("Bank is full");
                        break;
                    }
                    BaseAccount newBaseAccount = createAccount(scanner);
                    baseAccounts[accountCount++] = newBaseAccount;
//                    accounts.add(newAccount);
                    System.out.println("Account created successfully");

                    newBaseAccount.displayAccountDetails();

                    break;

                // deposit
                case 2:
                    BaseAccount currBaseAccountToDeposit = accountVerification(baseAccounts, accountCount, scanner);
                    if(currBaseAccountToDeposit != null){
                        int amountToDeposit = inputAmount(scanner);
                        if(currBaseAccountToDeposit.deposit(amountToDeposit)){
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
                    BaseAccount currBaseAccountToWithdraw = accountVerification(baseAccounts, accountCount, scanner);
                    if(currBaseAccountToWithdraw != null){
                        int amountToWithdraw = inputAmount(scanner);
                        if(currBaseAccountToWithdraw.withdraw(amountToWithdraw)){
                            System.out.println("Operation Done successfully");
                        }else{
                            System.out.println("Operation Failed");
                        }
                    }else{
                        System.out.println("No account found");
                    }
                    break;

                // transfer
                case 4:
                    System.out.println("Enter Details about the sender's account : ");
                    BaseAccount baseAccountSender = accountVerification(baseAccounts, accountCount, scanner);
                    if(baseAccountSender == null){
                        System.out.println("No account exist");
                        break;
                    }
                    System.out.println("Enter Details about the receiver's account : ");
                    BaseAccount baseAccountReceiver = accountVerification(baseAccounts, accountCount, scanner);

                    if(baseAccountReceiver == null){
                        System.out.println("No account exist");
                        break;
                    }

                    if(baseAccountReceiver.getAccountNumber() == baseAccountSender.getAccountNumber()){
                        System.out.println("Account number are same!! invalid");
                        break;
                    }

                    int amountToTransfer = inputAmount(scanner);

                    if(baseAccountSender.withdraw(amountToTransfer)){
                        if(baseAccountReceiver.deposit(amountToTransfer)){
                            System.out.println("Transfer Done successfully");
                        }else{
                            System.out.println("Issue at the reciever side");
                        }
                    }else{
                        System.out.println("Issue at the sender side");
                    }
                    break;

                // account detail
                case 5:
                    BaseAccount currBaseAccountToDisplay = accountVerification(baseAccounts, accountCount, scanner);
                    if(currBaseAccountToDisplay != null){
                        currBaseAccountToDisplay.displayAccountDetails();
                    }else{
                        System.out.println("Account not found");
                    }
                    break;

                // paying methods
                case 6:
                    BaseAccount account = accountVerification(baseAccounts, accountCount, scanner);
                    System.out.println("Opening available payment menu: ");
                    PaymentMenu.openPaymentMenu(account);

                    break;

                default:
                    System.out.println("Program Exited");
                    return;
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

    public static BaseAccount accountVerification(BaseAccount[] baseAccounts, int accountCount, Scanner scanner){
        int accountNumber;
        while(true){
            System.out.print("\n\nEnter account number : ");
            if(scanner.hasNextInt()){
                accountNumber = scanner.nextInt();
                for(int i = 0; i < accountCount; i++)
                    if (baseAccounts[i] != null && baseAccounts[i].getAccountNumber() == accountNumber) {
                        return baseAccounts[i];
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

    public static BaseAccount createAccount(Scanner scanner){
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

        if(accountType == 1){
            return new SavingBaseAccount(name, balance, "Saving");
        }else{
            return new CurrentBaseAccount(name, balance, "Current");

        }
    }
}
