package com.bank.model;

public class Account {
    private static int nextId= 100;
    private String accountNumber;
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.accountNumber = "ANO" + ++nextId;
        this.name = name;
        this.balance = balance;
    }


    public String getAccountNumber() {
        return accountNumber;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
