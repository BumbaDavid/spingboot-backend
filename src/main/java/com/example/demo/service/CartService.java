package com.example.demo.service;

import com.example.demo.dto.CartDto;
import com.example.demo.dto.CartItemDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    ProductService productService;

    @Autowired
    CartRepository cartRepository;

    public void addToCart(CartItemDto addToCartDto) {
        Product product = productService.findById(addToCartDto.getProduct().getId());

        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setQuantity(addToCartDto.getQuantity());
        cart.setCreatedDate(new Date());

        save(new Cart(product ,cart.getQuantity()));
    }

    public CartDto listCartItems() {
        List<Cart> cartList = cartRepository.findAll();
        List<CartItemDto> cartItems = new ArrayList<>();
        for (Cart cart:cartList){
            CartItemDto cartItemDto = getDtoFromCart(cart);
            cartItems.add(cartItemDto);
        }
        double totalCost = 0;
        for (CartItemDto cartItemDto :cartItems){
            totalCost += (cartItemDto.getProduct().getPrice()* cartItemDto.getQuantity());
        }
        return new CartDto(cartItems,totalCost);
    }

    public static CartItemDto getDtoFromCart(Cart cart) {
        return new CartItemDto(cart);
    }


    public void deleteCartItem(Integer cartItemId) {

        Optional<Cart> optionalCart = cartRepository.findById(cartItemId);

        if(optionalCart.isEmpty()){
            throw new ResourceNotFoundException("cart item id is invalid : " + cartItemId);
        }

        Cart cart = optionalCart.get();

        cartRepository.delete(cart);

    }

    public Cart save(Cart cart){
        return cartRepository.save(cart);
    }
}
