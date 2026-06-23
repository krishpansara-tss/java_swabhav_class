package com.librarymanagement.solution.models;

import com.librarymanagement.solution.interfaces.Borrowable;
import com.librarymanagement.solution.interfaces.FineCalculable;
import com.librarymanagement.solution.interfaces.ReferenceOnly;
import com.librarymanagement.solution.interfaces.Reservable;
import com.librarymanagement.solution.markerinterface.Item;

import java.util.Date;

public class Magazine implements Item, Borrowable, Reservable, FineCalculable, ReferenceOnly {
    private String issueNumber;
    private String title;
    private Date publicationDate;

    public Magazine(String issueNumber, String title, Date publicationDate) {
        this.issueNumber = issueNumber;
        this.title = title;
        this.publicationDate = publicationDate;
    }

    // Getters
    public String getTitle() { return title; }

    @Override
    public void borrowItem(String memberId) {
        System.out.println("[Magazine] '" + title + "' (Issue #" + issueNumber + ") borrowed by member: " + memberId);
    }

    @Override
    public void returnItem(String memberId) {
        System.out.println("[Magazine] '" + title + "' returned by member: " + memberId);
    }

    @Override
    public void reserveItem(String memberId) {
        System.out.println("[Magazine] '" + title + "' reserved for member: " + memberId);
    }

    @Override
    public double calculateFine(int daysOverdue) {
        return daysOverdue * 1.00;
    }

    @Override
    public boolean isReferenceOnly() {
        return false;
    }
}
