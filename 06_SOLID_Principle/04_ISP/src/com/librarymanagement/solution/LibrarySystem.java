package com.librarymanagement.solution;

import com.librarymanagement.solution.interfaces.*;
import com.librarymanagement.solution.markerinterface.Item;
import com.librarymanagement.solution.models.Book;
import com.librarymanagement.solution.models.Magazine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibrarySystem {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void borrowItem(Item item, String memberId) {
        if (item instanceof Borrowable) {
            ((Borrowable) item).borrowItem(memberId);
        } else {
            System.out.println("This item cannot be borrowed.");
        }
    }

    public void returnItem(Item item, String memberId) {
        if (item instanceof Borrowable) {
            ((Borrowable) item).returnItem(memberId);
        }
    }

    public void renewItem(Item item, String memberId) {
        if (item instanceof Renewable) {
            ((Renewable) item).renewItem(memberId);
        } else {
            System.out.println("Error: This item type is not renewable.");
        }
    }

    public void reserveItem(Item item, String memberId) {
        if (item instanceof Reservable) {
            ((Reservable) item).reserveItem(memberId);
        } else {
            System.out.println("Error: This item type cannot be reserved.");
        }
    }

    public double calculateFine(Item item, int daysOverdue) {
        if (item instanceof FineCalculable) {
            return ((FineCalculable) item).calculateFine(daysOverdue);
        }
        return 0.0;
    }

    public boolean isReferenceOnly(Item item) {
        if (item instanceof ReferenceOnly) {
            return ((ReferenceOnly) item).isReferenceOnly();
        }
        return true;
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        Book book = new Book("123-456", "Effective Java", "Joshua Bloch");
        Magazine magazine = new Magazine("Jan 2026", "National Geographic", new Date());

        library.addItem(book);
        library.addItem(magazine);

        System.out.println("--- Library Operations ---");
        library.borrowItem(book, "MEM_01");
        library.borrowItem(magazine, "MEM_02");

        System.out.println("\n--- Testing ISP Segregation Bounds ---");

        library.renewItem(book, "MEM_01");
        library.renewItem(magazine, "MEM_02");

        library.reserveItem(magazine, "MEM_03");
        library.reserveItem(book, "MEM_03");
    }
}
