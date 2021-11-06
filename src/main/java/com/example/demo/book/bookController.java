package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.*;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(path="api/v1/book")
public class bookController {


    private final bookService BookService;

    @Autowired
    public bookController(bookService bookService) {
        BookService = bookService;
    }


    @GetMapping
    public List<book> getbooks(){
        return BookService.getbooks();
    }


    @PostMapping(path = "/add")
    public void addNewBook(@RequestBody book Book){

        BookService.addNewbook(Book);
    }

    @DeleteMapping(path = "/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId){

        BookService.deleteBook(bookId);
    }



}
