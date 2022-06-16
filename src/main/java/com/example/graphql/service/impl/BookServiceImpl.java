package com.example.graphql.service.impl;

import com.example.graphql.dto.BookDto;
import com.example.graphql.exception.NotFoundException;
import com.example.graphql.model.BookEntity;
import com.example.graphql.repository.BookRepository;
import com.example.graphql.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorServiceImpl authorService;

    @Override
    public List<BookDto> findAllBooks() {
        final List<BookEntity> bookEntityList = bookRepository.findAll();
        return bookEntityList
            .stream()
            .map(this::mapBookToDto)
            .collect(Collectors.toList());
    }

    @Override
    public BookDto findById(final Long idBook) {
        final BookEntity bookEntity = findBookById(idBook);
        return mapBookToDto(bookEntity);
    }

    @Override
    public BookDto saveBook(BookDto bookDto, Long idAuthor) {
        return null;
    }

    private BookDto mapBookToDto(final BookEntity bookEntity) {
        final BookDto bookDto = new BookDto();
        bookDto.setTitle(bookEntity.getTitle());
        bookDto.setPages(bookEntity.getPages());
        bookDto.setAuthorDto(authorService.mapAuthorToDto(bookEntity.getAuthorEntity()));
        return bookDto;
    }

    private BookEntity findBookById(final Long id) {
        return bookRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Can not find Book with this id: " + id));
    }
}
