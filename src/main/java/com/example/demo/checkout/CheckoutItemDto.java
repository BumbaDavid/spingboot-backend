package com.example.demo.checkout;


public class CheckoutItemDto{
    private String productName;
    private int quantity;
    private double price;
    private long id;


    public CheckoutItemDto(){}

    public CheckoutItemDto(String productName, int quantity, double price, long id){
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
}