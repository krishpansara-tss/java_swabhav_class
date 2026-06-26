package com.tssconsultancy.structural.facade.solution.factory.impl;

import com.tssconsultancy.structural.facade.solution.factory.Hotel;
import com.tssconsultancy.structural.facade.solution.interfaces.Menu;
import com.tssconsultancy.structural.facade.solution.model.IndianMenu;

public class IndianCuisine implements Hotel {
    @Override
    public Menu getMenu() {
        return new IndianMenu();
    }
}
