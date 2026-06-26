package com.tssconsultancy.structural.decorator.hatwalaexample;

import com.tssconsultancy.structural.decorator.hatwalaexample.core.ProminentHat;
import com.tssconsultancy.structural.decorator.hatwalaexample.decorator.GoldenRibbon;
import com.tssconsultancy.structural.decorator.hatwalaexample.interfaces.Hat;

public class Main {
    public static void main(String[] args) {
        Hat hat = new ProminentHat();
        GoldenRibbon goldenRibbon = new GoldenRibbon(hat);
        System.out.println(goldenRibbon.getPrice());
    }
}
