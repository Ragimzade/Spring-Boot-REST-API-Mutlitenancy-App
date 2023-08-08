package com.example.springbootcrudapp.controller;

import com.example.springbootcrudapp.dto.BookDto;
import com.example.springbootcrudapp.dto.response.BookResponse;
import com.example.springbootcrudapp.entity.BookEntity;
import com.example.springbootcrudapp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(BookResponse.toBookResponse(bookService.getBook(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookResponse> deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(BookResponse.toBookResponse(bookService.create(bookDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@RequestBody BookDto bookDto, @PathVariable Long id) {
        return ResponseEntity.ok(BookResponse.toBookResponse(bookService.update(bookDto, id)));
    }
}
