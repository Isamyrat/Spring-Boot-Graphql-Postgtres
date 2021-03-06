package com.example.graphql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "BOOK")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "TITLE")
    private String title;

    @Column(nullable = false, name = "PAGES")
    private Integer pages;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    @JsonIgnore
    private AuthorEntity authorEntity;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BookEntity that = (BookEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) &&
               Objects.equals(pages, that.pages) && Objects.equals(authorEntity, that.authorEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, pages, authorEntity);
    }
}
