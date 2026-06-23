package com.librarymanagement.violation;

public class Book implements LibraryItem{
    String isbn;
    String title;
    String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
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
