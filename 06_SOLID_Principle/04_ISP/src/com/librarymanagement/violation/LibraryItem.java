package com.librarymanagement.violation;

public interface LibraryItem {
    void borrowItem(String memberId);
    void returnItem(String memberId);
    void renewItem(String memberId);
    void reserveItem(String memberId);
    double calculateFine(int daysOverdue);
    boolean isReferenceOnly();
}
