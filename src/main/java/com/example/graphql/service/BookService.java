package com.example.graphql.service;

import com.example.graphql.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> findAllBooks();
    BookDto findById(Long idBook);
    BookDto saveBook(BookDto bookDto, Long idAuthor);
}
