package com.tssconsultancy.behavioral.observertype.interfaces;

import com.tssconsultancy.behavioral.observertype.subject.Account;

public interface INotifier {
    void notify(Account account);
}
