package com.example.demo.book;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Service
public class bookService {


    private final bookRepository BookRepository;

    @Autowired
    public bookService(bookRepository bookRepository) {
        this.BookRepository = bookRepository;
    }

    public List<book> getbooks(){

        return BookRepository.findAll();
    }



    public  void addNewbook(book book) {

        Optional<book> bookOptional =  BookRepository.
                findBookBytitle(book.getTitle());

        if(bookOptional.isPresent()){

            throw new IllegalStateException(" Ksiązka jest w repo");
        }
        BookRepository.save(book);
        System.out.println(book);
    }


    public void deleteBook(Long bookId) {
        boolean exists = BookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException
                    ("Ksiązki nie ma w bazie");
        }
        BookRepository.deleteById(bookId);
    }


}
