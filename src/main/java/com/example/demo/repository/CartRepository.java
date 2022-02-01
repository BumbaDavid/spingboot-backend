package com.example.demo.repository;

import com.example.demo.model.Cart;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.util.List;


public interface CartRepository extends JpaRepository <Cart,Integer>, JpaSpecificationExecutor<Cart> {
    List<Cart> findAll(Specification<Cart> spec);
}
