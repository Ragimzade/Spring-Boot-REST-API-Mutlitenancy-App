package com.example.springbootcrudapp.service;

import com.example.springbootcrudapp.dto.BookDto;
import com.example.springbootcrudapp.entity.BookEntity;

import java.util.List;

public interface BookService {

    BookEntity getBook(long id);

    List<BookEntity> getAllBooks();

    BookEntity update(BookDto book, long id);

    void delete(long id);

    BookEntity create(BookDto book);
}
