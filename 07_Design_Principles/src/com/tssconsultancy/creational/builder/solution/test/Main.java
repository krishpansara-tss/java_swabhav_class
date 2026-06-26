package com.tssconsultancy.creational.builder.solution.test;

import com.tssconsultancy.creational.builder.solution.builderclass.Phone;
import com.tssconsultancy.creational.builder.solution.builderclass.PhoneBuilder;

public class Main {
    public static void main(String[] args) {
        PhoneBuilder phoneBuilder = new PhoneBuilder().
                setBattery(5000).
                setOs("android");

        Phone p = phoneBuilder.getPhone();
        System.out.println(p);
    }
}
