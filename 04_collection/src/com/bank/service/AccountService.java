package com.bank.service;

import com.bank.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    List<Account> accountArrayList = new ArrayList<>();

    public void createAccount(String name, double balance){
        Account newAccount = new Account(name , balance);
        accountArrayList.add(newAccount);
        System.out.println("Account created Successfully with AccountNumber : " + newAccount.getAccountNumber());
    }

    public void withdraw(String accountNumber, double amount){
        Account curr = isAccountExist(accountNumber);
        if(curr == null){
            System.out.println("Account not found");
            return;
        }

        if(curr.getBalance() < amount){
            System.out.println("Insufficient Balance");
            return;
        }
        double finalAmount = curr.getBalance() - amount;
        curr.setBalance(finalAmount);
        System.out.println("Amount withdrawn Successfully");
        System.out.println("Amount : " + curr.getBalance());
    }

    public void deposit(String accountNumber, double amount){
        Account curr = isAccountExist(accountNumber);
        if(curr == null){
            System.out.println("Account not found");
            return;
        }

        if(curr.getBalance() < amount){
            System.out.println("Insufficient Balance");
            return;
        }

        double finalAmount = curr.getBalance() + amount;
        curr.setBalance(finalAmount);
        System.out.println("Amount deposited Successfully");
        System.out.println("Amount : " + curr.getBalance());
    }

    public void transfer(String senderAccountNumber,  String receiverAccountNumber, double amount){
        Account senderAccount = isAccountExist(senderAccountNumber);
        if(senderAccount == null){
            System.out.println("Sender's account not exist");
            return;
        }

        Account recieverAccount = isAccountExist(receiverAccountNumber);
        if(recieverAccount == null){
            System.out.println("Receiver's account not exist");
            return;
        }

        this.withdraw(senderAccountNumber, amount);
        this.deposit(receiverAccountNumber, amount);
    }

    public void displayAccountDetail(String accountNumber){

        for (Account account : accountArrayList) {
            if(accountNumber.equals(account.getAccountNumber())){
                System.out.println("------ Account Details ------");
                System.out.println("Account Number: " + accountNumber);
                System.out.println("Account Holder Name: " + account.getName());
                System.out.println("Account Balance: " + account.getBalance());
                return;
            }
        }

        System.out.println("Account not found with account number : " + accountNumber);
    }

    public Account isAccountExist(String accountNumber){
        for (Account account : this.accountArrayList) {
            if(accountNumber.equals(account.getAccountNumber())){
                return account;
            }
        }

        return null;
    }

}
