package com.bank.account;

import java.util.Random;

public abstract class BaseAccount implements Account{
    private int accountId;
    private static int nextId = 0;
    private int accountNumber;
    private String name;
    private double balance;
    private String accountType;

    public BaseAccount(String name, double balance, String accountType){
        this.accountId = ++nextId;
        this.accountNumber = 10000000 + new Random().nextInt(90000000);
        this.name = name;
        this.balance = balance;
        this.accountType =accountType;
    }

    public BaseAccount(){
        this.accountId = ++nextId;
        this.accountNumber = 10000000 + new Random().nextInt(90000000);
        this.name = "Unknown";
        this.balance = 0;
        this.accountType = "Saving";
    }

    public int getAccountNumber() { return accountNumber;}
    public int getAccountId() { return accountId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }



    public void displayAccountDetails() {
        System.out.println("\n===== Account Details =====");
        System.out.println("Account Id : " + this.accountId);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + name);
        System.out.println("Account Type   : " + accountType);
        System.out.println("Balance        : ₹" + balance);
    }

    public double checkBalance() {
        return balance;
    }

//    public abstract boolean withdraw(double amount);
//    public abstract boolean deposit(double amount);

}
