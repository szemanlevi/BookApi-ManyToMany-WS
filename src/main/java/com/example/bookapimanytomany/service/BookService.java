package com.example.bookapimanytomany.service;

import com.example.bookapimanytomany.model.Book;
import com.example.bookapimanytomany.model.BookDto;
import com.example.bookapimanytomany.repository.BookDaoJPA;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookDaoJPA bookDaoJPA;

    public BookService(BookDaoJPA bookDaoJPA) {
        this.bookDaoJPA = bookDaoJPA;
    }

    public List<Book> findAll() {
        return bookDaoJPA.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookDaoJPA.findById(id);
    }

    public void save(BookDto book) {
        Book book1 = new Book(null, book.getTitle(), null);
        bookDaoJPA.save(book1);
    }
}
