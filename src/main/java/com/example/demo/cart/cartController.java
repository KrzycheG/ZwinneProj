package com.example.demo.cart;


import com.example.demo.book.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="api/v1/cart")
public class cartController {

    private final cartService CartService;


    @Autowired
    public cartController(cartService cartService) {
        CartService = cartService;
    }


    @GetMapping
    public List<cart> getcarts(){
        return CartService.getcarts();
    }

    @GetMapping("/cartBookList")
    public List<book> cartAllBooks(){

        return CartService.cartAllBooks();
    }

    @GetMapping("/suma")
    public List<Double> sumAll(){

        return CartService.sumAll();

    }

    @PostMapping("/books/{bookId}/carts")
    public void createCart(
            @PathVariable(value = "bookId") Long bookId,
            @RequestBody cart cartRequest
    ) {

        CartService.createCart(bookId,cartRequest);

    }

    @GetMapping("/quantity/{bookID}")
    public List<Integer> quantity(
            @PathVariable(value = "bookID") Long bookID
    ){

        return CartService.quantity(bookID);

    }

    @GetMapping("/quantityAdd/{bookID}/{quantity}")
    public String quantityAdd(
            @PathVariable(value = "bookID") Long bookID,
            @PathVariable(value = "quantity") int quantity
    ){

        CartService.quantityAdd(bookID,quantity);
        return "Gra gitara";
    }



    @DeleteMapping("/books/carts/{bookID}")
    public void deleteBookFromCart(
            @PathVariable(value = "bookID") Long bookID
    ){
        CartService.deleteBookFromCart(bookID);
    }


}
