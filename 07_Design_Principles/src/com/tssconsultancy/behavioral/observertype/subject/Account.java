package com.tssconsultancy.behavioral.observertype.subject;

import com.tssconsultancy.behavioral.observertype.factory.NotifierFactory;
import com.tssconsultancy.behavioral.observertype.interfaces.INotifier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Account {
    private static int nextId = 100;
    private String accountId;
    private String name;
    private double balance;
    Set<INotifier> notifiers = new HashSet<>();

    {
        nextId++;
    }

    public Account(String name, double balance, Set<INotifier> notifiers) {
        this.accountId = "CID" + nextId;
        this.name = name;
        this.balance = balance;
        this.notifiers = notifiers;
    }

    public void deposit(double amount){
        if(amount > balance){
            System.out.println("Insuffiecient balance");
            return;
        }

        setBalance(balance - amount);

        sendNotification();
        return;
    }

    public void withdraw(double amount){
        if(amount < 0){
            System.out.println("AMount can't be negatuve");
            return;
        }
        setBalance(balance + amount);
        sendNotification();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Set<INotifier> getNotifiers() {
        return notifiers;
    }

    private void sendNotification(){
        for(INotifier method : notifiers){
            method.notify(this);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public void setNotifiers(Set<INotifier> notifiers) {
        this.notifiers = notifiers;
    }
}
