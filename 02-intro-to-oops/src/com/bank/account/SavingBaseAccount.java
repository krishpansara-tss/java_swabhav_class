package com.bank.account;

import com.bank.exceptions.MinimumBalanceException;

public class SavingBaseAccount extends BaseAccount {
    private int minBalance;

    public SavingBaseAccount(String name, double balance, String accountType) {
        super(name, balance, accountType);
        this.minBalance =  500;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "minBalance=" + minBalance +
                '}';
    }


    @Override
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
            return false;
        }
        double balance = getBalance();

        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
        System.out.println("Updated Balance: ₹" + balance);

        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
            return false;
        }
        double balance = getBalance();

        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return false;
        }

        if((balance - amount) <= minBalance){
            throw new MinimumBalanceException();
//            System.out.println("Your account must have balance more than 500 after withdrawn.");
//            return false;
        }

        balance -= amount;
        setBalance(balance);
        System.out.println("₹" + amount + " withdrawn successfully.");
        System.out.println("Remaining Balance: ₹" + balance);
        return true;
    }

}
