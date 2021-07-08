package com.darkhouse.test_shop.exception;

public class OrderNotFoundException extends Exception{
    public OrderNotFoundException() {
        super("Order not found");
    }
}
