package com.sda.mark.bookmanagement.service;

import com.sda.mark.bookmanagement.model.Author;
import com.sda.mark.bookmanagement.repository.AuthorRepository;
import com.sda.mark.bookmanagement.repository.AuthorRepositoryImpl;
import com.sda.mark.bookmanagement.service.exceptions.InvalidParameterException;

public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void createAuthor(String firstName, String lastName) throws InvalidParameterException {
        if(firstName == null || firstName.isBlank() || firstName.length()<=2){
            throw new InvalidParameterException(
                    "Provided value for first name: " +
                    firstName + " is invalid");
        }
        if(lastName == null || lastName.isBlank() || lastName.length()<=2){
            throw new InvalidParameterException(
                    "Provided value for first name: " +
                            lastName + " is invalid");
        }

        authorRepository.create(new Author(firstName, lastName));
    }
}
