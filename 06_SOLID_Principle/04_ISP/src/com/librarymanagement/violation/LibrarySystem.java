package com.librarymanagement.violation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibrarySystem {
    private final List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem item) {
        items.add(item);
    }


    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
    }
}
