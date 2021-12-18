package com.example.demo.book;
import com.example.demo.cart.cart;
import com.example.demo.cart.cartRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.persistence.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class bookService {


    private final bookRepository BookRepository;

    @Autowired
    cartRepository CartRepository;

    @Autowired
    public bookService(bookRepository bookRepository) {
        this.BookRepository = bookRepository;
    }

    public List<book> getbooks(){

        ArrayList<book> asd = new ArrayList<>();

        List<book> AllbookList = BookRepository.findAll();

        for(book book1 : AllbookList){

            if(book1.getUnitsInStock() > 0){

                asd.add(book1);

            }

        }

        return asd;
    }

    public List<String> getCategories(){

        ArrayList<String> category = new ArrayList<>();

        for (book.category x : book.category.values()){
            category.add(x.toString());
        }
        return category;
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

    public void changeBookQuantity(Long bookId){

        book book1 = BookRepository.getById(bookId);
        cart cart1 = CartRepository.findByBooks_Id(bookId);

        book1.setUnitsInStock(book1.getUnitsInStock() - cart1.getQuantity());

        BookRepository.save(book1);
        if(book1.getUnitsInStock() < 1){

            System.out.println("Zamów więcej pozycji od producenta");
            System.out.println("ilosc brakujacych pozycji: " + (book1.getUnitsInStock() - cart1.getQuantity()));

        }


    }
}
