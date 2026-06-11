package com.bank.account;

public interface Account {
    int getAccountNumber();
    String getName();
    double getBalance();

    boolean deposit(double amount);
    boolean withdraw(double amount);

    void displayAccountDetails();
}
