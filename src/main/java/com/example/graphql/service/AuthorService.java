package com.example.graphql.service;

import com.example.graphql.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> findAllAuthors();
    AuthorDto findById(Long idAuthor);
    AuthorDto findByFirstNameAuthor(String firstName);
    AuthorDto saveAuthor(AuthorDto authorDto);
}
