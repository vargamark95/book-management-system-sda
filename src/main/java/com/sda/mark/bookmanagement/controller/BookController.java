package com.sda.mark.bookmanagement.controller;

import com.sda.mark.bookmanagement.service.BookService;
import com.sda.mark.bookmanagement.service.exceptions.EntityNotFoundException;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class BookController {
    private final BookService bookService;
    private final Scanner scanner = new Scanner(System.in);

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void createBook() {
        try {
            System.out.println("Please insert a book title: ");
            String title = scanner.nextLine();
            System.out.println("Please insert book description: ");
            String description = scanner.nextLine();
            System.out.println("please insert author id: ");
            int authorId = Integer.parseInt(scanner.nextLine());
            bookService.createBook(title, description, authorId);
        } catch (InvalidParameterException | EntityNotFoundException e) {
            e.getMessage();
        } catch (NumberFormatException e) {
            System.out.println("The author id is invalid");
        } catch (Exception e) {
            System.out.println("Internal server error");
        }
    }

    public void showAllBooks() {
        bookService.getAllBooks().stream().forEach(book -> System.out.println("Book with id: " + book.getId() +
                " " + book.getTitle() +
                " author " + book.getAuthor().getFirstName() +
                " " + book.getAuthor().getLastName())
        );
    }
}
