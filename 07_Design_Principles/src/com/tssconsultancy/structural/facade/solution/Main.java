package com.tssconsultancy.structural.facade.solution;

import com.tssconsultancy.structural.facade.solution.facade.HotelReception;

public class Main {
    public static void main(String[] args) {

        HotelReception reception = new HotelReception();

        reception.getIndianMenu();
        reception.getItalianMenu();
    }
}
