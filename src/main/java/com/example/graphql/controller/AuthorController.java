package com.example.graphql.controller;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.dto.AuthorDto;
import com.example.graphql.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorController implements GraphQLQueryResolver {

    private final AuthorService authorService;

    public List<AuthorDto> getAuthors() {
        return authorService.findAllAuthors();
    }
}
