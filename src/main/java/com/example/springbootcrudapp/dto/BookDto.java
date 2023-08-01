package com.example.springbootcrudapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {

    private String name;
    private String author;
    private int price;
}
