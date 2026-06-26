package com.tssconsultancy.behavioral.observertype.service;

import com.tssconsultancy.behavioral.observertype.subject.Account;

import java.util.*;

public class AccountService {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccount(String accountId) {
        for (Account acc : accounts) {
            if (acc.getAccountId().equals(accountId)) {
                return acc;
            }
        }
        return null;
    }
}