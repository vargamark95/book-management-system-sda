package com.sda.mark.bookmanagement.service;

import com.sda.mark.bookmanagement.model.Book;
import com.sda.mark.bookmanagement.model.Review;
import com.sda.mark.bookmanagement.repository.BookRepository;
import com.sda.mark.bookmanagement.repository.BookReviewRepository;
import com.sda.mark.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.mark.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.Optional;

public class BookReviewServiceImpl implements BookReviewService{

    private final BookReviewRepository bookReviewRepository;
    private final BookRepository bookRepository;

    public BookReviewServiceImpl(BookReviewRepository bookReviewRepository, BookRepository bookRepository) {
        this.bookReviewRepository = bookReviewRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void createBookReview(String bookTitle, int score, String comment) throws InvalidParameterException, EntityNotFoundException {
        if(bookTitle == null || bookTitle.isBlank() || bookTitle.length()<=2){
            throw new InvalidParameterException(
                    "Provided value for bookTitle: " +
                            bookTitle + " is invalid");
        }
        if(comment == null || comment.isBlank() || comment.length()<=2){
            throw new InvalidParameterException(
                    "Provided value for comment: " +
                            comment + " is invalid");
        }
        if(score<1 || score>5){
            throw new InvalidParameterException("Provided valuea for score: " + score + " is invalid");
        }
        Optional<Book> bookOptional = bookRepository.findByTitle(bookTitle);
        if(bookOptional.isEmpty()){
            throw new EntityNotFoundException("The book with the provided ttitle: " + bookTitle + " does not exist");
        }
        Book book = bookOptional.get();
        Review review = new Review(score, comment);
        review.setBook(book);
        bookReviewRepository.create(review);
    }
}
