package com.example.demo.controller;

import com.example.demo.common.ApiResponse;
import com.example.demo.dto.CartDto;
import com.example.demo.dto.CartItemDto;
import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepository;
import com.example.demo.service.CartService;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    public CartController(CartService cartService, CartRepository cartRepository) {
        this.cartService = cartService;

        this.cartRepository = cartRepository;
    }


    @PostMapping("/cart/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody CartItemDto addToCartDto){

        cartService.addToCart(addToCartDto);

        return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
    }

    @GetMapping("/cart")
    public ResponseEntity<Map<String,Object>> getCartItems(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @And({
                    @Spec(path = "name", spec = Equal.class)

            })Specification<Cart> cartSpec, Pageable pageable
    ){

        try{
            List<Cart> cart_ = new ArrayList<>();
            Page<Cart> cartTuts;

            cartTuts = cartRepository.findAll(cartSpec , pageable);

            cart_ = cartTuts.getContent();
            CartDto cartDto = cartService.listCartItems();

        Map<String,Object> response = new HashMap<>();

            response.put("cartItems", cart_);
            response.put("currentPage", cartTuts.getNumber());
            response.put("totalItems", cartTuts.getTotalElements());
            response.put("totalPages", cartTuts.getTotalPages());
            response.put("itemsPerPage", cartTuts.getSize());
            response.put("grandTotal",cartDto.getTotalCost());

        return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @DeleteMapping("/cart/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId")Integer itemId){
        cartService.deleteCartItem(itemId);

        return new ResponseEntity<>(new ApiResponse(true, "Deleted from cart"), HttpStatus.OK);
    }

}
