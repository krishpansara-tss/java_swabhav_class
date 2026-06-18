package com.collections.test;

import com.bank.model.Account;

import java.util.Comparator;

class NameComparator implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}