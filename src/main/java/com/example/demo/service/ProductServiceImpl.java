package com.example.demo.service;

import javax.transaction.Transactional;

import com.example.demo.exception.ProductDoesntExistException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;


import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;

    }

    @Override
    public Iterable <Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id){
        return productRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found!"));
    }

    @Override
    public Product save(Product product){
        return productRepository.save(product);
    }

    @Override
    public Product findById(long productId){
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if(optionalProduct.isEmpty()) {
            throw new ProductDoesntExistException("product is invalid " + productId);
        }

        return optionalProduct.get();
    }

}
