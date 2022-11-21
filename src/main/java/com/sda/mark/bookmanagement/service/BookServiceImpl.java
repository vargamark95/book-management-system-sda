package com.sda.mark.bookmanagement.service;

import com.sda.mark.bookmanagement.model.Author;
import com.sda.mark.bookmanagement.model.Book;
import com.sda.mark.bookmanagement.repository.AuthorRepository;
import com.sda.mark.bookmanagement.repository.BookRepository;
import com.sda.mark.bookmanagement.repository.BookRepositoryImpl;
import com.sda.mark.bookmanagement.service.BookService;
import com.sda.mark.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.mark.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    public BookServiceImpl( BookRepository bookRepository,AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void createBook(String title, String description, int authorId) throws InvalidParameterException, EntityNotFoundException {
        if (title == null || title.isBlank() || title.length() < 3) {
            throw new InvalidParameterException("Provided value for booktitle " + title +
                    " is invalid!");
        }
        if (description == null || description.isBlank() || description.length() < 10) {
            throw new InvalidParameterException("Provided description " + description +
                    " is invalid!");
        }
        if (authorId < 1) {
            throw new InvalidParameterException("Povided author id " + authorId + " in not valid");
        }
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        if (authorOptional.isEmpty()) {
            throw new EntityNotFoundException("The author with te provided id " + authorId + " was not found");
        }

        Author author = authorOptional.get();
        Book book = new Book(title, description);
        book.setAuthor(author);
        bookRepository.create(book);

    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void updateBook(int bookId, String title, String description, int authorId) throws EntityNotFoundException, InvalidParameterException {
        if(bookId <1 ){
            throw new InvalidParameterException(
                    "Provided value for author id : " +
                            bookId + " is invalid");
        }
        if (title == null || title.isBlank() || title.length() < 3) {
            throw new InvalidParameterException("Provided value for booktitle " + title +
                    " is invalid!");
        }
        if (description == null || description.isBlank() || description.length() < 10) {
            throw new InvalidParameterException("Provided description " + description +
                    " is invalid!");
        }
        if (authorId < 1) {
            throw new InvalidParameterException("Povided author id " + authorId + " in not valid");
        }

        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if(bookOptional.isEmpty()){
            throw new EntityNotFoundException("The book with the give id " + bookId + " does not exist!");
        }

        Optional<Author> authorOptional = authorRepository.findById(authorId);
        if(authorOptional.isEmpty()){
            throw new EntityNotFoundException("The author with the given id " + authorId + " does not exist!");
        }

        Author author = authorOptional.get();
        Book book = bookOptional.get();

        book.setTitle(title);
        book.setDescription(description);
        book.setAuthor(author);

        bookRepository.update(book);
    }

    @Override
    public void deleteBook(int bookId) throws InvalidParameterException, EntityNotFoundException {
        if(bookId<1){
            throw new InvalidParameterException("The provided id is not valid");
        }
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if(bookOptional.isEmpty()){
            throw new EntityNotFoundException("The book with the provided id " + bookId + " does not exist");
        }
        Book book = bookOptional.get();
        bookRepository.delete(book);
    }
}
