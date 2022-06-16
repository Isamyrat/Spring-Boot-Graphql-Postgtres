package com.example.graphql.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;
    private Integer pages;
    private AuthorDto authorDto;
}
