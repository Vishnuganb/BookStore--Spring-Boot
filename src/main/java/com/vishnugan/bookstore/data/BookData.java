package com.vishnugan.bookstore.data;

import com.vishnugan.bookstore.entity.Book;

import java.util.List;

public class BookData {

    private List<Book> books;

    private Book book;

    public List<Book> getBooks () {
        return books;
    }

    public Book getBook () {
        return book;
    }

    public void setBook ( Book book ) {
        this.book = book;
    }

    public void setBooks ( List<Book> books ) {
        this.books = books;
    }
}
