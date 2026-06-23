package com.librarymanagement.violation;

import java.util.Date;

public class Magazine implements LibraryItem {
    String issueNumber;
    String title;
    Date publicationDate;

    public Magazine(String issueNumber, String title, Date publicationDate) {
        this.issueNumber = issueNumber;
        this.title = title;
        this.publicationDate = publicationDate;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public String getTitle() {
        return title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    @Override
    public void borrowItem(String memberId) {

    }

    @Override
    public void returnItem(String memberId) {

    }

    @Override
    public void renewItem(String memberId) {

    }

    @Override
    public void reserveItem(String memberId) {

    }

    @Override
    public double calculateFine(int daysOverdue) {
        return 0;
    }

    @Override
    public boolean isReferenceOnly() {
        return false;
    }
}
