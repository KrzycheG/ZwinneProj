package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.*;
import java.awt.print.Book;
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

    @GetMapping(path = "/categories")
    public List<String> getCategories(){ return BookService.getCategories();}


    @PostMapping(path = "/add")
    public void addNewBook(@RequestBody book Book){

        BookService.addNewbook(Book);
    }

    @DeleteMapping(path = "/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId){

        BookService.deleteBook(bookId);
    }

    public void changeBookQuantity(
            long bookId
    ){

        BookService.changeBookQuantity(bookId);
    }




}
