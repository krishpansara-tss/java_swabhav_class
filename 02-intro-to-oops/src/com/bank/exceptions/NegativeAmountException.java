package com.bank.exceptions;

public class NegativeAmountException extends RuntimeException {
    private double amount;
    public NegativeAmountException(double amount) {
        this.amount = amount;
    }

    public String getMessage(){
        return "You have entered negative amount, it must be positive";
    }
}
