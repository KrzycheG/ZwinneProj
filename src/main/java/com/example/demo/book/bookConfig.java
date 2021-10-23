package com.example.demo.book;
import javax.persistence.*;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

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
                    1,"https://images-na.ssl-images-amazon.com/images/I/61zxVpKmL8L.jpg"
            );
            book it = new book(
                    22L,
                    "IT",
                    "Stephen King",
                    "Viking",
                    1986,
                    39.99,
                    25 ,
                    2,"https://i.ebayimg.com/images/g/glQAAOSwiTNgAEMG/s-l500.jpg"
            );
            book ToE = new book(
                    33L,
                    "The Theory of Everything: The Origin and Fate of the Universe",
                    "Stephen Hawking",
                    "Jaico Publishing House",
                    2002,
                    79.99,
                    125 ,
                    3,"https://prestigebookshop.com/wp-content/uploads/2019/02/book-image-5642.jpg"
            );
            book DVC = new book(
                    44L,
                    "The Da Vinci Code",
                    "Dan Brown",
                    "Doubleday",
                    2003,
                    69.99,
                    72 ,
                    4,"https://anylang.net/sites/default/files/styles/book_image/public/covers/the-da-vinci-code-589f9cee3df78c4758a2d9e7.jpg?itok=Qs2nkb__"
            );
            book FiOS = new book(
                    55L,
                    "The Fault in Our Stars",
                    "John Green",
                    "Dutton Books",
                    2012,
                    39.99,
                    12 ,
                    5,"https://images-na.ssl-images-amazon.com/images/I/51BYcXvTimL._SX332_BO1,204,203,200_.jpg"
            );

            List<book> is = List.of(hobbit,it,ToE,DVC,FiOS);
            for(book x: is ){
               boolean bla = repository.findBookBytitle(x.getTitle()).isPresent();
                System.out.println(bla);
                if(!bla){
                    repository.save(x);

                }
            }
        };
    }
}
