package com.tssconsultancy.structural.facade.solution.model;

import com.tssconsultancy.structural.facade.solution.interfaces.Menu;

public class IndianMenu implements Menu {
    @Override
    public void displayMenu() {
        System.out.println("Indian Menu: Dal, Roti, Paneer");
    }
}
