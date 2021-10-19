package com.example.demo.book;

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
            book potop = new book(
                    1L,
                    "Potop","x","x",1,
                    25,5 ,1
            );


            repository.saveAll(
                    List.of(potop) // dopisac reszte po przecinku
            );
        };
    }
}
