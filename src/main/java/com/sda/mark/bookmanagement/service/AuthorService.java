package com.sda.mark.bookmanagement.service;

import com.sda.mark.bookmanagement.model.Author;
import com.sda.mark.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.Arrays;
import java.util.List;

public interface AuthorService {
    void createAuthor(String firstName, String lastName) throws InvalidParameterException;


    List<Author> getAllAuthors();
}
