package com.tssconsultancy.structural.composite.model;

import com.tssconsultancy.structural.composite.interfaces.FileSystem;

public class File implements FileSystem {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}
