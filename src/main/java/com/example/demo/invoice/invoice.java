package com.example.demo.invoice;

import com.example.demo.book.book;

public class invoice {

    private Long invoiceID;
    private String lastName;
    private String firstName;
    private String street;
    private int apartmentNumber;
    private int houseNumber;
    private String city;
    private int zipCode;
    private String country;

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
}
