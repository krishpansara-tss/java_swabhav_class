package com.tssconsultancy.behavioral.observertype.observer;

import com.tssconsultancy.behavioral.observertype.interfaces.INotifier;
import com.tssconsultancy.behavioral.observertype.subject.Account;

public class Whatsapp implements INotifier {
    @Override
    public void notify(Account account) {
        System.out.println("[WHATSAPP NOTIFICATION]: Your account balance has been updated to: " + account.getBalance());
    }
}
