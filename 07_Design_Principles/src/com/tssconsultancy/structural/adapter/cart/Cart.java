package com.tssconsultancy.structural.adapter.cart;

import com.tssconsultancy.structural.adapter.interfaces.IItems;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<IItems> items = new ArrayList<>();


    public void addItems(IItems item){
        items.add(item);
    }

    public List<IItems> getItem(){
        return items;
    }

    public double getCartPrice(){
        double total = 0;
        for(IItems i : items){
            total += i.getPrice();
        }

        return total;
    }

    public void displayCart() {
        System.out.println("Item Name\tPrice");

        for (IItems item : items) {
            System.out.println(item.getName() + "\t\t" + item.getPrice());
        }

        System.out.println("----------------------");
        System.out.println("Total: " + getCartPrice());
    }

}
