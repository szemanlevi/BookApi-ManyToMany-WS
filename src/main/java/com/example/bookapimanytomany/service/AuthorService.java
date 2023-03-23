package com.example.bookapimanytomany.service;

import com.example.bookapimanytomany.model.Author;
import com.example.bookapimanytomany.repository.AuthorDaoJPA;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorDaoJPA authorDaoJPA;

    public AuthorService(AuthorDaoJPA authorDaoJPA) {
        this.authorDaoJPA = authorDaoJPA;
    }

    public List<Author> findAll() {
        return authorDaoJPA.findAll();
    }

    public Optional<Author> findById(Long id) {
        return authorDaoJPA.findById(id);
    }
}
