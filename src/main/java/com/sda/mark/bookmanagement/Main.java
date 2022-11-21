package com.sda.mark.bookmanagement;

import com.sda.mark.bookmanagement.controller.AuthorController;
import com.sda.mark.bookmanagement.menu.UserOption;
import com.sda.mark.bookmanagement.repository.AuthorRepositoryImpl;
import com.sda.mark.bookmanagement.service.AuthorServiceImpl;
import com.sda.mark.bookmanagement.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SessionManager.getSessionFactory();
        AuthorController authorController = new AuthorController(new AuthorServiceImpl(new AuthorRepositoryImpl()));
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
