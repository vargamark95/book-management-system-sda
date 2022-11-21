package com.sda.mark.bookmanagement.repository;

import com.sda.mark.bookmanagement.model.Review;

public class BookReviewRepositoryImpl extends BaseRepositoryImpl<Review> implements BookReviewRepository{
    public BookReviewRepositoryImpl() {
        super(Review.class);
    }
}
