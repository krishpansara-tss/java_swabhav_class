package com.tssconsultancy.structural.proxy;

import com.tssconsultancy.structural.proxy.interfaces.Image;
import com.tssconsultancy.structural.proxy.proxyclass.ProxyImage;

public class Main {
    public static void main(String[] args) {

        Image img = new ProxyImage("photo.jpg");

        // image will be displayed after loading
        img.display();

        // only display
        img.display();
    }
}
