package com.sda.mark.bookmanagement;

import com.sda.mark.bookmanagement.controller.AuthorController;
import com.sda.mark.bookmanagement.controller.BookController;
import com.sda.mark.bookmanagement.controller.ReviewController;
import com.sda.mark.bookmanagement.menu.UserOption;
import com.sda.mark.bookmanagement.repository.AuthorRepositoryImpl;
import com.sda.mark.bookmanagement.repository.BookRepositoryImpl;
import com.sda.mark.bookmanagement.repository.BookReviewRepositoryImpl;
import com.sda.mark.bookmanagement.service.AuthorServiceImpl;
import com.sda.mark.bookmanagement.service.BookReviewServiceImpl;
import com.sda.mark.bookmanagement.service.BookServiceImpl;
import com.sda.mark.bookmanagement.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SessionManager.getSessionFactory();
        AuthorController authorController = new AuthorController(new AuthorServiceImpl(new AuthorRepositoryImpl()));
        BookController bookController = new BookController(new BookServiceImpl(new BookRepositoryImpl(), new AuthorRepositoryImpl()));
        ReviewController reviewController = new ReviewController(new BookReviewServiceImpl(new BookReviewRepositoryImpl(), new BookRepositoryImpl()));
        Scanner scanner = new Scanner(System.in);

        UserOption userOption;

        do {
            UserOption.printAllOptions();
            System.out.println("Please select an option");
            try {
                int numericOption = Integer.parseInt(scanner.nextLine());
                userOption = UserOption.findUserOption(numericOption);
            } catch (NumberFormatException e) {
                userOption = UserOption.UNKNOWN;
            }

            switch(userOption){
                case CREATE_AUTHOR:
                    authorController.createAuthor();
                    break;
                case SHOW_ALL_AUTHORS:
                    authorController.showAllAuthors();
                    break;
                case UPDATE_AUTHOR:
                    authorController.updateAuthor();
                    break;
                case DELETE_AUTHOR:
                    authorController.deleteAuthor();
                    break;
                case CREATE_BOOK:
                    bookController.createBook();
                    break;
                case SHOW_ALL_BOOKS:
                    bookController.showAllBooks();
                    break;
                case UPDATE_BOOK:
                    bookController.updateBook();
                    break;
                case DELETE_BOOK:
                    bookController.deleteBook();
                    break;
                case CREATE_REVIEW:
                    reviewController.createBookReview();
                    break;
                case EXIT:
                    System.out.println("Goodbye!");
                    break;
                case UNKNOWN:
                    System.out.println("Option Unknown");
                    break;
                default:
                    System.out.println("User option " + userOption + "is not implemented!");
            }
        } while (userOption != UserOption.EXIT);
        SessionManager.shutDown();

    }
}
