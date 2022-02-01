package com.example.demo.model;

import java.time.LocalDate;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "placed_orders")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderProducts")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDate dateCreated;

    private String firstName;
    private String lastName;
    private String address;
    private String country;
    private String cardNumber;
    private String postalCode;
    private String securityCode;
    private String email;
    private String phone;
    private String expirationDate;

    @ManyToOne
    private Cart cart;

    //public Order(){}

    public Order(LocalDate dateCreated, String firstName, String lastName, String address, String country,
                 String cardNumber, String postalCode, String securityCode, String email, Cart cart, String phone, String expirationDate) {
        this.dateCreated = dateCreated;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.country = country;
        this.cardNumber = cardNumber;
        this.postalCode = postalCode;
        this.securityCode = securityCode;
        this.email = email;
        this.cart = cart;
        this.phone = phone;
        this.expirationDate = expirationDate;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cart getCart() {
        return cart;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
