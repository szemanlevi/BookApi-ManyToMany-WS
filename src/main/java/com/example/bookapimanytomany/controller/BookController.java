package com.example.bookapimanytomany.controller;

import com.example.bookapimanytomany.model.Book;
import com.example.bookapimanytomany.model.BookDto;
import com.example.bookapimanytomany.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private final BookService bookService;

    //    7. Add an endpoint to save new books, authors
//Add save to service
//Add @PostMapping handling method to controllers
//How can you handle adding authors to books and vica versa?
//Use Postman to send randomly books with randomly generated titles, and authors with random names

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    @Operation(summary = "book API", description = "get all books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> findById(@Parameter(description = "book id", required = true) @PathVariable("id") Long id) {
        return bookService.findById(id);
    }

    @PostMapping("/books")
    public void saveBook(@RequestBody BookDto book) {
        bookService.save(book);
    }
}
