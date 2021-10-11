package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/book")
public class bookController {

    private final bookService BookService;

    @Autowired
    public bookController(bookService bookService) {
        this.BookService = bookService;

    }

    @GetMapping
    public List<book> getbooks(){

        return BookService.getbooks();
    }

}
