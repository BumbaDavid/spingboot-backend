package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class CheckoutController{
    @Autowired
    private CheckoutService CheckoutService;

    @PostMapping("/create-checkout-session")
    public ResponseEntity<StripeResponse> checkoutList()
}