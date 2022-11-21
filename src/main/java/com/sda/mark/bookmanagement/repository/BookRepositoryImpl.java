package com.sda.mark.bookmanagement.repository;

import com.sda.mark.bookmanagement.model.Book;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book> implements BookRepository{

    public BookRepositoryImpl() {
        super(Book.class);
    }
}
