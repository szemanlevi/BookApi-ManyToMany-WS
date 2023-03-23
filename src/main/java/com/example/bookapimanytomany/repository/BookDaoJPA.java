package com.example.bookapimanytomany.repository;

import com.example.bookapimanytomany.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDaoJPA extends JpaRepository<Book, Long> {
}
