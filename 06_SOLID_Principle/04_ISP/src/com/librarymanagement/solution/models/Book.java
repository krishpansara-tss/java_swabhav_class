package com.librarymanagement.solution.models;

import com.librarymanagement.solution.interfaces.Borrowable;
import com.librarymanagement.solution.interfaces.FineCalculable;
import com.librarymanagement.solution.interfaces.ReferenceOnly;
import com.librarymanagement.solution.interfaces.Renewable;
import com.librarymanagement.solution.markerinterface.Item;

public class Book implements Item, Borrowable, Renewable, FineCalculable, ReferenceOnly {
    private String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }

    @Override
    public void borrowItem(String memberId) {
        System.out.println("[Book] '" + title + "' borrowed by member: " + memberId);
    }

    @Override
    public void returnItem(String memberId) {
        System.out.println("[Book] '" + title + "' returned by member: " + memberId);
    }

    @Override
    public void renewItem(String memberId) {
        System.out.println("[Book] '" + title + "' renewed for member: " + memberId);
    }

    @Override
    public double calculateFine(int daysOverdue) {
        return daysOverdue * 0.50;
    }

    @Override
    public boolean isReferenceOnly() {
        return false;
    }
}
