package com.example.demo.exception;



public class ProductDoesntExistException extends IllegalArgumentException{

public ProductDoesntExistException(String msg){
    super(msg);
}

}
