package com.example.demo.book;



import com.example.demo.cart.cart;
import com.example.demo.invoice.invoice;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

enum category{
    Thiller ,Dramat, Scifi,Horror,Fantasy, Romance
}
//
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table
 public class book {


    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    @Column(nullable = true)
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private int publicationDate;
    private category categoryName;
    private double price;
    private int unitsInStock;
    private String cover;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="books", orphanRemoval = true)
    private List<cart> carts = new ArrayList<>();



    public book(Long id, String title,String author, String publisher, int publicationDate, double price, int unitsInStock, category categoryName, String cover) {

        this.id = id;
        this.title = title;
        this.author =author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.price = price;
        this.unitsInStock = unitsInStock;
        this.categoryName = categoryName;
        this.cover = cover;


    }

    public book() {
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int quantity) {
        this.unitsInStock = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(int publicationDate) {
        this.publicationDate = publicationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public category getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(category categoryName) {
        this.categoryName = categoryName;
    }

    public String getCover() {return cover;}

    public void setCover(String cover) {this.cover = cover;}

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                ", publication date=" + publicationDate +
                ", price=" + price +
                ", units in stock=" + unitsInStock +
                ", category name=" + categoryName +
                '}';
    }
    enum category{
        Thiller ,Dramat, Scifi,Horror,Fantasy, Romance
    }

}
