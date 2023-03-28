package com.example.bookapimanytomany.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "bookList")
    @Fetch(FetchMode.SUBSELECT)
    @JsonBackReference
    private List<Author> authorList;
}
