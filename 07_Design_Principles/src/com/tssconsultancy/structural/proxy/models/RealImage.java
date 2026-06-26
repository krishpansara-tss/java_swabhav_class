package com.tssconsultancy.structural.proxy.models;

import com.tssconsultancy.structural.proxy.interfaces.Image;

public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image:  " + fileName);
    }
}
