package com.example.bookapimanytomany.controller;

import com.example.bookapimanytomany.model.Author;
import com.example.bookapimanytomany.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    @ResponseBody
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @GetMapping("/authors/{id}")
    @ResponseBody
    public Optional<Author> findById(@PathVariable("id") Long id) {
        return authorService.findById(id);
    }
}
