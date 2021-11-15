package com.example.demo.cart;


import com.example.demo.book.book;
import com.example.demo.invoice.invoice;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Cart")
@Table(name = "cart")
public class cart {


    @Id
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "cart_sequence"
    )
    @Column(nullable = true)
    private Long cartID;
    private int quantity;
    private double cartTotalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bookID", nullable=true)
    private book books;


    @OneToMany(
            mappedBy = "cart",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<invoice> invoices= new ArrayList<>();


    public cart(int quantity, double cartTotalPrice) {
        this.quantity = quantity;
        this.cartTotalPrice = cartTotalPrice;
    }

    public cart(Long cartID, int quantity, double cartTotalPrice) {
        this.cartID = cartID;
        this.quantity = quantity;
        this.cartTotalPrice = cartTotalPrice;
    }

    public cart() {
    }

    public Long getCartID() {return cartID;}
    public void setCartID(Long cartID) {this.cartID = cartID;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public double getCartTotalPrice() {return cartTotalPrice;}
    public void setCartTotalPrice(double cartTotalPrice) {this.cartTotalPrice = cartTotalPrice;}

    @Override
    public String toString() {
        return "cart{" +
                "cartID=" + cartID +
                ", quantity=" + quantity +
                ", cartTotalPrice=" + cartTotalPrice +
                '}';
    }
}
