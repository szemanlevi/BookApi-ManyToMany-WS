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
    public void saveBook(@RequestBody BookDto bookDto) {
        bookService.save(bookDto);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(Long id) {
        bookService.delete(id);
    }
}
