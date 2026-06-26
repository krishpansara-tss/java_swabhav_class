package com.tssconsultancy.behavioral.iteratortype;

import com.tssconsultancy.behavioral.iteratortype.interfaces.Iterator;
import com.tssconsultancy.behavioral.iteratortype.model.Book;
import com.tssconsultancy.behavioral.iteratortype.model.BookCollection;

public class Main {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection(5);

        collection.addBook(new Book("Java"));
        collection.addBook(new Book("Python"));
        collection.addBook(new Book("C++"));

        Iterator it = collection.getIterator();

        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}
