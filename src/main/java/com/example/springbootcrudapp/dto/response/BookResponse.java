package com.example.springbootcrudapp.dto.response;

import com.example.springbootcrudapp.entity.BookEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponse {

    private String id;
    private String name;
    private String author;
    private int price;


    public static BookResponse toBookResponse(BookEntity bookEntity) {
        return BookResponse.builder()
                .id(String.valueOf(bookEntity.getId()))
                .name(bookEntity.getName())
                .author(bookEntity.getAuthor())
                .price(bookEntity.getPrice())
                .build();
    }
}
