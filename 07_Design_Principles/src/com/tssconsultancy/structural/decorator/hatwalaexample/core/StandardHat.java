package com.tssconsultancy.structural.decorator.hatwalaexample.core;

import com.tssconsultancy.structural.decorator.hatwalaexample.interfaces.Hat;

public class StandardHat implements Hat {
    @Override
    public double getPrice() {
        return 200;
    }
}
