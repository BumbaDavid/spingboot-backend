package com.example.demo.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.example.demo.controller.OrderController;
import com.example.demo.model.Order;

import org.springframework.validation.annotation.Validated;

@Validated
public interface OrderService {
    @NotNull Iterable<Order> getAllOrders();

    Order create(@NotNull(message = "The order cannot be null") @Valid Order order);

    void update(@NotNull(message = " The order cannot be null") @Valid Order order);

    void addOrder(@Valid Order order);

    Order save(Order order);
}
