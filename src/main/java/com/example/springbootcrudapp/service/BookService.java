package com.example.springbootcrudapp.service;

import com.example.springbootcrudapp.dto.BookDto;
import com.example.springbootcrudapp.entity.BookEntity;

import java.util.List;

public interface BookService {

    BookEntity getBook(int id);

    List<BookEntity> getAllBooks();

    BookEntity update(BookDto book, int id);

    void delete(int id);

    BookEntity create(BookDto book);
}
