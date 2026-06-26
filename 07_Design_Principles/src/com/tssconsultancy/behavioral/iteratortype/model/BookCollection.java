package com.tssconsultancy.behavioral.iteratortype.model;

import com.tssconsultancy.behavioral.iteratortype.interfaces.Container;
import com.tssconsultancy.behavioral.iteratortype.interfaces.Iterator;

public class BookCollection implements Container {

    private Book[] books;
    private int size = 0;

    public BookCollection(int capacity) {
        books = new Book[capacity];
    }

    public void addBook(Book book) {
        books[size++] = book;
    }

    @Override
    public Iterator getIterator() {
        return new BookIterator();
    }

    private class BookIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return books[index++];
            }
            return null;
        }
    }
}
