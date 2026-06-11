package com.bank.payment.service;

import com.bank.account.BaseAccount;
import com.bank.payment.methods.Payment;

public class PaymentService {
    public void paymentProcess(Payment payment, BaseAccount account, double amount){
        payment.collectDetails();
        payment.pay(account, amount);
    }
}
