package com.sda.mark.bookmanagement.service;

import com.sda.mark.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.mark.bookmanagement.service.exceptions.InvalidParameterException;

public interface BookReviewService {

    void createBookReview(String bookTitle, int score, String comment) throws InvalidParameterException, EntityNotFoundException;
}
