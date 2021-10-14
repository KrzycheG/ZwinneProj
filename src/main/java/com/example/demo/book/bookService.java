package com.example.demo.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookService {
    public bookService(bookRepository bookRepository) {
        BookRepository = bookRepository;
    }
    @Autowired
    private final bookRepository BookRepository;
    public List<book> getbooks(){

        return BookRepository.findAll();
    }
}
