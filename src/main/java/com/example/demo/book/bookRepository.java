package com.example.demo.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepository
        extends JpaRepository<book,Long> {
}
