package com.example.demo.controller;

import com.example.demo.common.ApiResponse;
import com.example.demo.dto.OrderProductDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    ProductService productService;

    @Autowired
    OrderService orderService;



    public OrderController(){
    }

    public OrderController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Order> list() {
        return this.orderService.getAllOrders();
    }

    @PostMapping("/order/add")
    public ResponseEntity<ApiResponse> create(@RequestBody Order order) {

        orderService.save(order);

        return new ResponseEntity<>(new ApiResponse(true, "Order placed"), HttpStatus.CREATED);
    }

    private void validateProductsExistence(List<OrderProductDto> orderProducts) {
        List<OrderProductDto> list = orderProducts
          .stream()
          .filter(op -> Objects.isNull(productService.getProduct(op
            .getProduct()
            .getId())))
          .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)) {
            new ResourceNotFoundException("Product not found");
        }
    }

    public static class OrderForm {

        private List<OrderProductDto> productOrders;

        public List<OrderProductDto> getProductOrders() {
            return productOrders;
        }

        public void setProductOrders(List<OrderProductDto> productOrders) {
            this.productOrders = productOrders;
        }
    }
}

