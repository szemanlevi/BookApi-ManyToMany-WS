package com.example.bookapimanytomany.service;

import com.example.bookapimanytomany.model.Author;
import com.example.bookapimanytomany.model.AuthorDto;
import com.example.bookapimanytomany.model.Book;
import com.example.bookapimanytomany.repository.AuthorDaoJPA;
import com.example.bookapimanytomany.repository.BookDaoJPA;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorDaoJPA authorDaoJPA;
    private final BookDaoJPA bookDaoJPA;

    public AuthorService(AuthorDaoJPA authorDaoJPA, BookDaoJPA bookDaoJPA) {
        this.authorDaoJPA = authorDaoJPA;
        this.bookDaoJPA = bookDaoJPA;
    }

    public List<Author> findAll() {
        return authorDaoJPA.findAll();
    }

    public Optional<Author> findById(Long id) {
        return authorDaoJPA.findById(id);
    }

    public void save(AuthorDto authorDto) {
        List<Book> books = authorDto.getBookIdList()
                .stream()
                .flatMap(id -> bookDaoJPA.findById(id).stream())
                .toList();
        Author author = new Author(null, authorDto.getName(), books);
        authorDaoJPA.save(author);
    }
}
