package com.example.demo.cart;

import com.example.demo.book.book;
import com.example.demo.book.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;



@Service
public class cartService {

    @Autowired
    cartRepository CartRepository;

    @Autowired
    public bookRepository BookRepository;


    public List<cart> getcarts() {

        return CartRepository.findAll();
    }

    public void createCart(
             Long bookId,
             cart cartRequest
    ) {
         BookRepository.findById(bookId)
                .map(book -> {
                    cartRequest.setBooks(book);
                    return CartRepository.save(cartRequest);
                });


    }

    public List<book> cartAllBooks(){

        List<cart> carts = CartRepository.findAll();
        ArrayList<book> boks = new ArrayList<>();

        for(cart x : carts){

                boks.add(x.getBooks());
            System.out.println(x);

        }
        List<book> result;
        result = boks;
        return result;
    }

    public List<Double> sumAll(){

        List<book> sumBook = cartAllBooks();
        List<Double> suma = new ArrayList<>();
        double sumo = 0;
        for(book x : sumBook){

            sumo+= x.getPrice();
        }
        suma.add(sumo);

        return suma;

    }

    public void deleteBookFromCart(
            Long bookID
    ) {

        cart cartDel = CartRepository.findByBooks_Id(bookID);

        CartRepository.findByCartIDAndBooks_Id(cartDel.getCartID(), bookID).map(comment -> {
            CartRepository.delete(comment);
            return ResponseEntity.ok().build();

        });

    }
}
