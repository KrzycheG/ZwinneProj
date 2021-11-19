package com.example.demo.invoice;

import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Invoice")
@Table(name = "invoice")
public class invoice {

    @Id
    @SequenceGenerator(
            name = "invoice_sequence",
            sequenceName = "invoice_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "invoice_sequence"
    )
    @Column(
            name = "id"
    )
    private Long invoiceID;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "street",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String street;

    @Column(
            name = "apartment_number",
            nullable = false

    )
    private int apartmentNumber;

    @Column(
            name = "house_number",
            nullable = false

    )
    private int houseNumber;

    @Column(
            name = "city",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String city;

    @Column(
            name = "zip_code",
            nullable = false

    )
    private int zipCode;

    @Column(
            name = "country",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String country;


    @ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(name = "cart_id")
    private com.example.demo.cart.cart cart;



    public invoice(Long invoiceID, String lastName,
                   String firstName, String street,
                   int apartmentNumber, int houseNumber,
                   String city, int zipCode, String country) {
        this.invoiceID = invoiceID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.houseNumber = houseNumber;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    public invoice(String lastName, String firstName,
                   String street, int apartmentNumber,
                   int houseNumber, String city, int zipCode,
                   String country) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.houseNumber = houseNumber;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    public invoice() {
    }

    public Long getInvoiceID() {return invoiceID;}
    public void setInvoiceID(Long invoiceID) {this.invoiceID = invoiceID;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}

    public int getApartmentNumber() {return apartmentNumber;}
    public void setApartmentNumber(int apartmentNumber) {this.apartmentNumber = apartmentNumber;}

    public int getHouseNumber() {return houseNumber;}
    public void setHouseNumber(int houseNumber) {this.houseNumber = houseNumber;}

    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    public int getZipCode() {return zipCode;}
    public void setZipCode(int zipCode) {this.zipCode = zipCode;}

    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}

    @Override
    public String toString() {
        return "invoice{" +
                "invoiceID=" + invoiceID +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", street='" + street + '\'' +
                ", apartmentNumber=" + apartmentNumber +
                ", houseNumber=" + houseNumber +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", country='" + country + '\'' +
                '}';
    }
}
