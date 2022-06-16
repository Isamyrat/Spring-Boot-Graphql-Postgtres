package com.example.graphql.controller;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.dto.BookDto;
import com.example.graphql.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookController implements GraphQLQueryResolver {

    private final BookService bookService;

    public List<BookDto> getBooks() {
        return bookService.findAllBooks();
    }

}
