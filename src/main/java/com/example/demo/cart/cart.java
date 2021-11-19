package com.example.demo.cart;


import com.example.demo.book.book;
import com.example.demo.invoice.invoice;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bookID", nullable=true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private book books;



    @OneToMany(
            mappedBy = "cart",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<invoice> invoices= new ArrayList<>();


    public cart(int quantity) {
        this.quantity = quantity;

    }

    public cart(Long cartID, int quantity) {
        this.cartID = cartID;
        this.quantity = quantity;

    }

    public cart() {
    }

    public Long getCartID() {return cartID;}
    public void setCartID(Long cartID) {this.cartID = cartID;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public book getBooks() {
        return books;
    }

    public void setBooks(book books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "cart{" +
                "cartID=" + cartID +
                ", quantity=" + quantity +
                '}';
    }
}
