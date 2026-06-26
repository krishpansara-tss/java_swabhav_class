package com.tssconsultancy.structural.facade.solution.model;

import com.tssconsultancy.structural.facade.solution.interfaces.Menu;

public class ItalianMenu implements Menu {
    @Override
    public void displayMenu() {
        System.out.println("Italian Menu: Pizza, Pasta");
    }
}
