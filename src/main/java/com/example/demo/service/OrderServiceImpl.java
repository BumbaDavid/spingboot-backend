package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;
   
    public OrderServiceImpl(OrderRepository orderRepository, CartService cartService, CartRepository cartRepository){
        this.orderRepository=orderRepository;
        this.cartService = cartService;
        this.cartRepository = cartRepository;
    }
    
    @Override
    public Iterable<Order> getAllOrders(){
        return this.orderRepository.findAll();
    }

    @Override
    public Order create(Order order){
        order.setDateCreated(LocalDate.now());

        return this.orderRepository.save(order);
    }

    @Override
    public void addOrder(Order order){
        //Order order_ = new Order();
    }

    @Override
    public Order save(Order order){
        return orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }
}
