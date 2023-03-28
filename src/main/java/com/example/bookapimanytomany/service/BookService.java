package com.example.bookapimanytomany.service;

import com.example.bookapimanytomany.model.Author;
import com.example.bookapimanytomany.model.Book;
import com.example.bookapimanytomany.model.BookDto;
import com.example.bookapimanytomany.repository.AuthorDaoJPA;
import com.example.bookapimanytomany.repository.BookDaoJPA;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookDaoJPA bookDaoJPA;
    private final AuthorDaoJPA authorDaoJPA;

    public BookService(BookDaoJPA bookDaoJPA,
                       AuthorDaoJPA authorDaoJPA) {
        this.bookDaoJPA = bookDaoJPA;
        this.authorDaoJPA = authorDaoJPA;
    }

    public List<Book> findAll() {
        return bookDaoJPA.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookDaoJPA.findById(id);
    }

    public void save(BookDto bookDto) {
        List<Author> authors = bookDto.getAuthorIdList()
                .stream()
                .flatMap(id -> authorDaoJPA.findById(id).stream())
                .toList();
        Book book = new Book(null, bookDto.getTitle(), authors);
        authors.forEach(author -> author.getBookList().add(book));
        bookDaoJPA.save(book);
    }

    public void delete(Long id) {
        Book book = bookDaoJPA.findById(id).orElseThrow();
        book.getAuthorList()
                .forEach(author -> {
                    author.getBookList().removeIf(book1 -> book1.getId().equals(id));
                    authorDaoJPA.save(author);
                });
        book.setAuthorList(List.of());
        bookDaoJPA.save(book);
        bookDaoJPA.deleteById(id);
    }
}
