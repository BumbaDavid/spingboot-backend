package com.example.demo.checkout;


public class CheckoutItemDto{
    private String productName;
    private int quantity;
    private double price;
    private long id;
    private String shippingAdress;
    private String billingAdress;
    private String deliveryMode;



    public CheckoutItemDto(){}

    public CheckoutItemDto(String productName, int quantity, double price, long id, String shippingAdress, String billingAdress, String deliveryMode){
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
        this.shippingAdress= shippingAdress;
        this.billingAdress = billingAdress;
        this.deliveryMode =deliveryMode;
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
    
    public String getShippingAdress(){
        return shippingAdress;
    }

    public void setShippingAdress(String shippingAdress){
        this.shippingAdress = shippingAdress;
    }

    public String getBillingAdress(){
        return billingAdress;
    }

    public void setBillingAdress(String billingAdress){
        this.billingAdress = billingAdress;
    }

    public String getDeliveryMode(){
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode){
        this.deliveryMode = deliveryMode;
    }
}