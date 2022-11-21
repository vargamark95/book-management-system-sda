package com.sda.mark.bookmanagement.service;

import com.sda.mark.bookmanagement.model.Author;
import com.sda.mark.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.mark.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.Arrays;
import java.util.List;

public interface AuthorService {
    void createAuthor(String firstName, String lastName) throws InvalidParameterException;

    void updateAuthor(int id, String firstName, String lastName) throws InvalidParameterException, EntityNotFoundException;

    void deleteAuthor(int id) throws InvalidParameterException, EntityNotFoundException;


    List<Author> getAllAuthors();
}
