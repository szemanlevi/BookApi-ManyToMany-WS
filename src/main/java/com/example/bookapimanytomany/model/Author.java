package com.example.bookapimanytomany.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns =
            @JoinColumn(name = "author_id"),
            inverseJoinColumns =
            @JoinColumn(name = "book_id")
    )
    @JsonManagedReference
    private List<Book> bookList;
}
