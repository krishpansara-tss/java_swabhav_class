package com.tssconsultancy.structural.adapter;

import com.tssconsultancy.structural.adapter.adapter.HatAdapter;
import com.tssconsultancy.structural.adapter.cart.Cart;
import com.tssconsultancy.structural.adapter.interfaces.IItems;
import com.tssconsultancy.structural.adapter.items.Biscuit;
import com.tssconsultancy.structural.adapter.items.Chocolate;
import com.tssconsultancy.structural.adapter.items.Hat;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();

        cart.addItems(new Biscuit("parle-g", 10));
        cart.addItems(new Chocolate("silak", 100));
        Hat hat = new Hat("Hat", "Fancy", 500, 2);
        cart.addItems(new HatAdapter(hat));
        cart.displayCart();
    }
}
