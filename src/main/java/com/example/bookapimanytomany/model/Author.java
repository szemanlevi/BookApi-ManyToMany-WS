package com.example.bookapimanytomany.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
