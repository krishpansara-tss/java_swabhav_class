package com.librarymanagement.solution.interfaces;

public interface Borrowable {
    void borrowItem(String memberId);
    void returnItem(String memberId);
}
