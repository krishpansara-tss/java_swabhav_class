package com.tssconsultancy.structural.composite.model;

import com.tssconsultancy.structural.composite.interfaces.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystem {
    private String name;
    private List<FileSystem> items = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystem item) {
        items.add(item);
    }

    public void showDetails() {
        System.out.println("Folder: " + name);

        for (FileSystem item : items) {
            item.showDetails();
        }
    }
}
