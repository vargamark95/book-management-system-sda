package com.sda.mark.bookmanagement.service;

import com.sda.mark.bookmanagement.service.exceptions.InvalidParameterException;

public interface AuthorService {
    void createAuthor(String firstName, String lastName) throws InvalidParameterException;


}
