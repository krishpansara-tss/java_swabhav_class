package com.bank.exceptions;

public class MinimumBalanceException extends RuntimeException {
//    double currentBalance;
    public MinimumBalanceException() {
//        this.currentBalance = currentBalance;
    }

    public String getMessage(){
        return "You must have to maintain minimum balance of 500 in your account";
    }

}
