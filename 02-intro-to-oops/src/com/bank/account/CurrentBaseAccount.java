package com.bank.account;

public class CurrentBaseAccount extends BaseAccount {
    private double overdraftLimit,  overdraftUsed;


    public CurrentBaseAccount(String name, double balance, String accountType) {
        super(name, balance, accountType);
        this.overdraftLimit = 10000;
        this.overdraftUsed = 0;
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();

        System.out.println("Overdraft Limit: ₹" + overdraftLimit);
        System.out.println("Overdraft Used: ₹" + overdraftUsed);

    }


    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
            return false;
        }
        double balance = getBalance();

        double available = balance + (overdraftLimit - overdraftUsed);

        if (amount > available) {
            System.out.println("Insufficient balance including overdraft.");
            return false;
        }

        if (amount <= balance) {
            balance -= amount;
            setBalance(balance);
        } else {
            double remaining = amount - balance;
            balance = 0;
            setBalance(balance);
            overdraftUsed += remaining;
        }

        System.out.println("₹" + amount + " withdrawn successfully.");
        System.out.println("Balance: ₹" + balance);
        System.out.println("Overdraft Used: ₹" + overdraftUsed);

        return true;
    }

    @Override
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
            return false;
        }

        if (overdraftUsed > 0) {
            if (amount >= overdraftUsed) {
                amount -= overdraftUsed;
                System.out.println("₹" + overdraftUsed + " used to clear overdraft.");
                overdraftUsed = 0;
            } else {
                overdraftUsed -= amount;
                System.out.println("₹" + amount + " used to partially clear overdraft.");
                amount = 0;
            }
        }
        double balance = getBalance();

        if (amount > 0) {
            balance += amount;
            setBalance(balance);
        }

        System.out.println("Balance: ₹" + balance);
        System.out.println("Overdraft Used: ₹" + overdraftUsed);

        return true;
    }
}
