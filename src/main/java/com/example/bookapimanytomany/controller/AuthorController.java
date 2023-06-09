package com.example.bookapimanytomany.controller;

import com.example.bookapimanytomany.model.Author;
import com.example.bookapimanytomany.model.AuthorDto;
import com.example.bookapimanytomany.service.AuthorService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @GetMapping("/authors/{id}")
    public Optional<Author> findById(@PathVariable("id") Long id) {
        return authorService.findById(id);
    }

    @PostMapping("/authors")
    @Parameter(description = "this saves author to database")
    public void saveAuthor(@RequestBody AuthorDto authorDto) {
        authorService.save(authorDto);
    }
}
