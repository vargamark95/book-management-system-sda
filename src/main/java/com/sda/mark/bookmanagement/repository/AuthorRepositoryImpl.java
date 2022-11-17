package com.sda.mark.bookmanagement.repository;

import com.sda.mark.bookmanagement.model.Author;

public class AuthorRepositoryImpl extends BaseRepositoryImpl<Author> implements AuthorRepository{
    public AuthorRepositoryImpl() {
        super(Author.class);
    }
}
