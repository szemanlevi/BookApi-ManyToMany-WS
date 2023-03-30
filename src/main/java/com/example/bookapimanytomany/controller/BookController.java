package com.example.bookapimanytomany.controller;

import com.example.bookapimanytomany.model.Book;
import com.example.bookapimanytomany.model.BookDto;
import com.example.bookapimanytomany.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

//    @PostMapping("/books")
//    public ResponseEntity<String> saveBook(@RequestBody BookDto bookDto) {
//        if (bookDto.getTitle().isBlank()) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        bookService.save(bookDto);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @PostMapping("/books")
    public void saveBook(@Valid @RequestBody BookDto bookDto) {
        bookService.save(bookDto);
    }

//    @PostMapping("/books")
//    public void saveBook(@RequestBody @Valid BookDto bookDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw new RuntimeException();
//        } else {
//            bookService.save(bookDto);
//        }
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        String numberOfErrors = String.valueOf(ex.getBindingResult().getAllErrors().size());
        errors.put("number of errors: ", numberOfErrors);
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(Exception.class)
//    public Map<String, String> handleExceptions(Exception ex) {
//        Map<String, String> errors = new HashMap<>();
////        ex.getBindingResult().getAllErrors().forEach((error) -> {
////            String fieldName = ((FieldError) error).getField();
////            String errorMessage = error.getDefaultMessage();
////            errors.put(fieldName, errorMessage);
////        });
//        return errors;
//    }


    @DeleteMapping("/books/{id}")
    public void deleteBook(Long id) {
        bookService.delete(id);
    }
}
