package com.tssconsultancy.debug;

import java.util.*;

class Order {
    String customerName;
    List<Integer> itemPrices;

    Order(String customerName, List<Integer> itemPrices) {
        this.customerName = customerName;
        this.itemPrices = itemPrices;
    }
}

public class OrderProcessor {

    public static void main(String[] args) {

        List<Order> orders = new ArrayList<>();

        orders.add(new Order("Amit", Arrays.asList(100, 200, 300)));
        orders.add(new Order("Sara", Arrays.asList(50, 50)));
        orders.add(new Order("John", Arrays.asList(1000)));

        for (Order order : orders) {
            int total = calculateTotal(order.itemPrices);
            double finalAmount = applyDiscount(total, order.itemPrices.size());

            System.out.println(order.customerName + " pays: " + finalAmount);
        }
    }

    private static int calculateTotal(List<Integer> prices) {
        int sum = 0;

        for (int i = 0; i < prices.size(); i++) {
            sum += prices.get(i);
        }

        return sum;
    }

    private static double applyDiscount(int total, int itemCount) {

        double discount = 0;

        if (itemCount > 2) {
            discount = total * 0.2;
        } else if (itemCount == 2) {
            discount = total * 0.1;
        } else {
            discount = total * 0.05;
        }

        return total - discount;
    }
}
