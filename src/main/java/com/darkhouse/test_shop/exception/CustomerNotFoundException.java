package com.darkhouse.test_shop.exception;

public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException() {
        super("Customer not found");
    }
}
