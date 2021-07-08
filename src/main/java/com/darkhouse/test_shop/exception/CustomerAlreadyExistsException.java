package com.darkhouse.test_shop.exception;

public class CustomerAlreadyExistsException extends Exception{
    public CustomerAlreadyExistsException() {
        super("Customer with chosen name already exists");
    }
}
