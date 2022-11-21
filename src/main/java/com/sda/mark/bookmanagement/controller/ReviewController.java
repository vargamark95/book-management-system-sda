package com.sda.mark.bookmanagement.controller;

import com.sda.mark.bookmanagement.repository.BookReviewRepository;
import com.sda.mark.bookmanagement.service.BookReviewService;
import com.sda.mark.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.mark.bookmanagement.service.exceptions.InvalidParameterException;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Scanner;

public class ReviewController {

    private final Scanner scanner = new Scanner(System.in);
    private final BookReviewService bookReviewService;

    public ReviewController(BookReviewService bookReviewService) {
        this.bookReviewService = bookReviewService;
    }

    public void createBookReview(){
        try{
            System.out.println("Please insert a book title: ");
            String bookTitle = scanner.nextLine();
            System.out.println("Please insert a comment: ");
            String comment = scanner.nextLine();
            System.out.println("Please insert a score: ");
            int score = Integer.parseInt(scanner.nextLine());

            bookReviewService.createBookReview(bookTitle, score, comment);
        }catch (InvalidParameterException e){
            e.getMessage();
        }catch (EntityNotFoundException e){
            e.getMessage();
        }catch(NumberFormatException e){
            System.out.println("The provided score is not a number!");
        }catch (Exception e){
            System.out.println("Internal server error!");
        }


    }
}
