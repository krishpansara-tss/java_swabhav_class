package com.tssconsultancy.structural.facade.solution.facade;

import com.tssconsultancy.structural.facade.solution.factory.Hotel;
import com.tssconsultancy.structural.facade.solution.factory.impl.IndianCuisine;
import com.tssconsultancy.structural.facade.solution.factory.impl.ItalianCuisine;
import com.tssconsultancy.structural.facade.solution.interfaces.Menu;

public class HotelReception {
    public void getIndianMenu() {
        Hotel hotel = new IndianCuisine();
        Menu menu = hotel.getMenu();
        menu.displayMenu();
    }

    public void getItalianMenu() {
        Hotel hotel = new ItalianCuisine();
        Menu menu = hotel.getMenu();
        menu.displayMenu();
    }
}
