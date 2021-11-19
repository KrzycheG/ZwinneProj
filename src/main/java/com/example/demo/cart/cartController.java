package com.example.demo.cart;


import com.example.demo.book.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

}
