package com.sda.mark.bookmanagement.repository;

import com.sda.mark.bookmanagement.model.Book;

import java.util.Optional;

public interface BookRepository extends BaseRepository<Book>{
        Optional<Book> findByTitle(String title);

}
