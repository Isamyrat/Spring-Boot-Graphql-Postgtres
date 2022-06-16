package com.example.graphql.service.impl;

import com.example.graphql.dto.AuthorDto;
import com.example.graphql.exception.NotFoundException;
import com.example.graphql.model.AuthorEntity;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<AuthorDto> findAllAuthors() {
        final List<AuthorEntity> authorEntityList = authorRepository.findAll();
        return authorEntityList
            .stream()
            .map(this::mapAuthorToDto)
            .collect(Collectors.toList());
    }

    @Override
    public AuthorDto findById(final Long idAuthor) {
        final AuthorEntity user = findAuthorById(idAuthor);
        return mapAuthorToDto(user);
    }

    @Override
    public AuthorDto findByFirstNameAuthor(final String firstName) {
        final AuthorEntity authorEntity = findAuthorByFirstName(firstName);
        return mapAuthorToDto(authorEntity);
    }

    @Override
    public AuthorDto saveAuthor(final AuthorDto authorDto) {
        final AuthorEntity authorEntity = fillingInAuthorData(authorDto);
        authorRepository.save(authorEntity);
        return authorDto;
    }
    private AuthorEntity fillingInAuthorData(final AuthorDto authorDto) {
        final AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setFirstName(authorDto.getFirstName());
        authorEntity.setLastName(authorDto.getLastName());
        return authorEntity;
    }

    public AuthorDto mapAuthorToDto(final AuthorEntity authorEntity) {
        final AuthorDto authorDto = new AuthorDto();
        authorDto.setFirstName(authorEntity.getFirstName());
        authorDto.setLastName(authorEntity.getLastName());
        return authorDto;
    }

    private AuthorEntity findAuthorById(final Long id) {
        return authorRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Can not find Author with this id: " + id));
    }
    private AuthorEntity findAuthorByFirstName(final String firstName) {
        return authorRepository.findByFirstName(firstName)
            .orElseThrow(() -> new NotFoundException("Can not find Author with this firstName: " + firstName));
    }
}
