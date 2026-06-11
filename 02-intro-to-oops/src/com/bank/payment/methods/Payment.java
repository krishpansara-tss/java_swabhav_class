package com.bank.payment.methods;

import com.bank.account.BaseAccount;

public interface Payment {
    void collectDetails();
    void pay(BaseAccount account, double amount);
}
