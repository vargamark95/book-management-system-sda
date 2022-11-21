package com.sda.mark.bookmanagement.service;

import com.sda.mark.bookmanagement.model.Author;
import com.sda.mark.bookmanagement.repository.AuthorRepository;
import com.sda.mark.bookmanagement.repository.AuthorRepositoryImpl;
import com.sda.mark.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.mark.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.List;
import java.util.Optional;

public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void createAuthor(String firstName, String lastName) throws InvalidParameterException {
        if(firstName == null || firstName.isBlank() || firstName.length()<=2){
            throw new InvalidParameterException(
                    "Provided value for first name: " +
                    firstName + " is invalid");
        }
        if(lastName == null || lastName.isBlank() || lastName.length()<=2){
            throw new InvalidParameterException(
                    "Provided value for first name: " +
                            lastName + " is invalid");
        }

        authorRepository.create(new Author(firstName, lastName));
    }

    @Override
    public void updateAuthor(int id, String firstName, String lastName) throws InvalidParameterException, EntityNotFoundException {
        if(id <1 ){
            throw new InvalidParameterException(
                    "Provided value for author id : " +
                            id + " is invalid");
        }
        if(firstName == null || firstName.isBlank() || firstName.length()<=2){
            throw new InvalidParameterException(
                    "Provided value for first name: " +
                            firstName + " is invalid");
        }
        if(lastName == null || lastName.isBlank() || lastName.length()<=2){
            throw new InvalidParameterException(
                    "Provided value for first name: " +
                            lastName + " is invalid");
        }
        Optional<Author> author = authorRepository.findById(id);
        if(author.isEmpty()){
            throw new EntityNotFoundException("Author with id: " + id + " doesn't exists");
        }
        author.get().setFirstName(firstName); //author.get dezbraca author-ul de optional, sau il scoate din optional
        author.get().setLastName(lastName);
        authorRepository.update(author.get());
    }

    @Override
    public void deleteAuthor(int id) throws InvalidParameterException, EntityNotFoundException {
        if(id <1 ){
            throw new InvalidParameterException(
                    "Provided value for author id : " +
                            id + " is invalid");
        }
        Optional<Author> author = authorRepository.findById(id);
        if(author.isEmpty()){
            throw new EntityNotFoundException("Author with id: " + id + " doesn't exists");
        }

        authorRepository.delete(author.get());
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }




}
