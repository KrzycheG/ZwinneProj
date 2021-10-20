package com.example.demo.book;
import javax.persistence.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class bookConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            bookRepository repository){

        return args -> {
            book hobbit = new book(
                    11L,
                    "Hobbit",
                    "J. R. R. Tolkien",
                    "George Allen & Unwin",
                    1937,
                    29.99,
                    45 ,
                    1
            );
            book it = new book(
                    22L,
                    "IT",
                    "Stephen King",
                    "Viking",
                    1986,
                    39.99,
                    25 ,
                    2
            );
            book ToE = new book(
                    33L,
                    "The Theory of Everything: The Origin and Fate of the Universe",
                    "Stephen Hawking",
                    "Jaico Publishing House",
                    2002,
                    79.99,
                    125 ,
                    3
            );
            book DVC = new book(
                    44L,
                    "The Da Vinci Code",
                    "Dan Brown",
                    "Doubleday",
                    2003,
                    69.99,
                    72 ,
                    4
            );
            book FiOS = new book(
                    55L,
                    "The Fault in Our Stars",
                    "John Green",
                    "Dutton Books",
                    2012,
                    39.99,
                    12 ,
                    5
            );


            repository.saveAll(
                    List.of(hobbit,it,ToE,DVC,FiOS) // dopisac reszte po przecinku
            );
        };
    }
}
