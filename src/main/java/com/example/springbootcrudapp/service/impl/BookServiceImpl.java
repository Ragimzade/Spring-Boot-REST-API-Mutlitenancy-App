package com.example.springbootcrudapp.service.impl;

import com.example.springbootcrudapp.dto.BookDto;
import com.example.springbootcrudapp.entity.BookEntity;
import com.example.springbootcrudapp.repository.BookRepository;
import com.example.springbootcrudapp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public List<BookEntity> getAllBooks() {
        List<BookEntity> bookEntities = new ArrayList<>();
        bookRepository.findAll().forEach(bookEntities::add);
        return bookEntities;
    }

    @Override
    public BookEntity update(BookDto book, int id) {
        BookEntity entity = getBook(id);
        entity.setPrice(book.getPrice());
        entity.setName(book.getName());
        entity.setAuthor(book.getAuthor());

        return entity;
    }

    public BookEntity getBook(int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book with id '%s' is not found".formatted(id)));
    }

    public BookEntity create(BookDto book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setName(book.getName());
        bookEntity.setPrice(book.getPrice());
        return bookRepository.save(bookEntity);
    }

    public void delete(int id) {
        BookEntity book = getBook(id);
        bookRepository.delete(book);
    }

}
