package com.example.springbootcrudapp.repository;

import com.example.springbootcrudapp.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
