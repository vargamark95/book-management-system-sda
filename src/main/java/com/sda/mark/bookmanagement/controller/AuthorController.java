package com.sda.mark.bookmanagement.controller;

import com.sda.mark.bookmanagement.service.AuthorService;
import com.sda.mark.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.mark.bookmanagement.service.exceptions.InvalidParameterException;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Scanner;

public class AuthorController {

    private final AuthorService authorService;
    private final Scanner scanner = new Scanner(System.in);

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    public void createAuthor(){

        try{
            System.out.println("Please insert author first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Please insert author last name: ");
            String lastName = scanner.nextLine();
            authorService.createAuthor(firstName, lastName);
            System.out.println("Author was created!");
        }catch(InvalidParameterException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("Internal server error!");
        }

    }

    public void updateAuthor(){
        try{
            System.out.println("Please insert an author id: ");
            int authorId = Integer.parseInt((scanner.nextLine()));
            System.out.println("Please insert author first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Please insert author last name: ");
            String lastName = scanner.nextLine();
            authorService.updateAuthor(authorId, firstName, lastName);
            System.out.println("Author was updated!");
        }catch(EntityNotFoundException | InvalidParameterException e){
            System.out.println(e.getMessage());
        }catch (NumberFormatException n){
            System.out.println("Provided author id is not a number!");
        }catch(Exception e){
            System.out.println("Internal server error!");
        }
    }

    public void deleteAuthor(){
        try{
            System.out.println("Please insert author id: ");
            int authorId = Integer.parseInt(scanner.nextLine());
            authorService.deleteAuthor(authorId);
            System.out.println("Author with" + authorId + "was succesfully deleted!");
        } catch (InvalidParameterException | EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }catch(NumberFormatException e){
            System.out.println("Provided author id is not a number!");
        }
        catch (Exception e){
            System.out.println("Internal server error!");
        }
    }

    public void showAllAuthors(){
        authorService.getAllAuthors().stream().forEach(author ->
                System.out.println("Author with ID: " + author.getId() + " " + author.getFirstName() +
                        " " + author.getLastName()
        ));
    }
}
