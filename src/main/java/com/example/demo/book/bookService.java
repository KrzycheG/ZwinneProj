package com.example.demo.book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookService {
    public List<book> getbooks(){
        return List.of(
                new book(
                        "Potop",
                        25,5
                )
        );
    }
}
