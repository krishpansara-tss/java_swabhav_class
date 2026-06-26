package com.tssconsultancy.behavioral.observertype.factory;

import com.tssconsultancy.behavioral.observertype.interfaces.INotifier;
import com.tssconsultancy.behavioral.observertype.observer.Email;
import com.tssconsultancy.behavioral.observertype.observer.SMS;
import com.tssconsultancy.behavioral.observertype.observer.Whatsapp;

import java.util.HashSet;
import java.util.Set;

public class NotifierFactory {

    public static Set<INotifier> createNotifiers(String input) {
        String[] types = input.split(" ");
        Set<INotifier> notifiers = new HashSet<>();

        for (String type : types) {
            switch (type) {
                case "1" -> notifiers.add(new SMS());
                case "2" -> notifiers.add(new Whatsapp());
                case "3" -> notifiers.add(new Email());
                default -> {
                    System.out.println("Invalid choice → Default SMS added");
                    notifiers.add(new SMS());
                }
            }
        }

        return notifiers;
    }
}