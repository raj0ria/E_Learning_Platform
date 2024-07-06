package com.rajoria.jpa.repositories;

import com.rajoria.jpa.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findByEmail(String email);
}
