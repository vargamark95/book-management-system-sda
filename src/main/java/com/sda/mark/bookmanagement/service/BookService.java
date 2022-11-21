package com.sda.mark.bookmanagement.service;

import com.sda.mark.bookmanagement.model.Book;
import com.sda.mark.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.mark.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.List;

public interface BookService {

    void createBook(String title, String description, int authorId) throws EntityNotFoundException, InvalidParameterException;

    List<Book> getAllBooks();

    void updateBook(int bookId, String title, String description, int authorId) throws EntityNotFoundException, InvalidParameterException;

    void deleteBook(int bookId) throws InvalidParameterException, EntityNotFoundException;



}
